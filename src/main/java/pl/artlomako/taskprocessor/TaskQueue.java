package pl.artlomako.taskprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue<T extends Task> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskQueue.class);

    private final LinkedList<T> tasks;
    private final Lock lock;
    private final Condition canReceiveTasks;
    private final int itemsCountToResumeReceiving;
    private final int limit;

    public TaskQueue(int limit) {
        this.tasks = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.canReceiveTasks = this.lock.newCondition();
        this.itemsCountToResumeReceiving = limit / 2;
        this.limit = limit;
    }

    public void push(T task) throws InterruptedException {
        this.lock.lock();
        try {
            while (this.tasks.size() == limit) {
                LOGGER.info("Task queue is full. Waiting");
                this.canReceiveTasks.await();
            }

            this.tasks.add(task);
            LOGGER.debug("Pushed task {}. Queue size: [{}]", task, this.tasks.size());

        } finally {
            this.lock.unlock();
        }
    }

    public Optional<T> pop() {
        this.lock.lock();
        try {

            T task = this.tasks.pollLast();
            if (task == null) {
                return Optional.empty();
            }
            LOGGER.debug("Popped task {}. Queue size: [{}]", task, this.tasks.size());

            if (this.tasks.size() == this.itemsCountToResumeReceiving) {
                LOGGER.info("Achieved tasks receiving limit. Resuming");
                this.canReceiveTasks.signal();
            }

            return Optional.of(task);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isEmpty() {
        this.lock.lock();
        try {
            return tasks.isEmpty();
        } finally {
            this.lock.unlock();
        }
    }
}
