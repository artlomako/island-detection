package pl.artlomako.islanddetection.islandslookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artlomako.islanddetection.Point;
import pl.artlomako.taskprocessor.FindIslandsTask;
import pl.artlomako.taskprocessor.FindIslandsTaskConsumer;
import pl.artlomako.taskprocessor.TaskQueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConcurrentIslandsLookup implements IslandsLookup {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConcurrentIslandsLookup.class);

    private final int consumersCount;
    private final ExecutorService consumersThreadPool;
    private static final int PARTITION_SIZE = 1000;


    public ConcurrentIslandsLookup(int consumersCount) {
        this.consumersCount = consumersCount;
        this.consumersThreadPool = Executors.newFixedThreadPool(consumersCount);
    }

    @Override
    public int countIslands(boolean[][] map) throws Exception {
        LOGGER.info("Counting islands concurrently");
        if(map.length == 0 || map[0].length == 0) {
            return 0;
        }

        AtomicBoolean shouldRun = new AtomicBoolean(true);
        Set<Set<Point>> islands = Collections.synchronizedSet(new HashSet<>());

        TaskQueue<FindIslandsTask> taskQueue = initializeConsumers(shouldRun, islands);
        runProducerSynchronously(map, shouldRun, taskQueue);

        shutdownConsumersPool();

        int islandsCount = islands.size();
        LOGGER.info("Found {} islands", islandsCount);
        return islandsCount;
    }

    private void shutdownConsumersPool() throws InterruptedException {
        LOGGER.info("Shutting down consumers pool");
        consumersThreadPool.shutdown();
        LOGGER.info("Waiting for consumers pool termination");
        consumersThreadPool.awaitTermination(60, TimeUnit.MINUTES);
        LOGGER.info("Consumers pool terminated");
    }

    private void runProducerSynchronously(boolean[][] map,
                                          AtomicBoolean shouldRun,
                                          TaskQueue<FindIslandsTask> taskQueue) throws InterruptedException {
        LOGGER.info("Running task producer");
        int rowsCount = map.length;
        int colsCount = map[0].length;

        for (int row = 0; row < rowsCount; row += PARTITION_SIZE) {
            for (int col = 0; col < colsCount; col += PARTITION_SIZE) {
                Point startPoint = new Point(row, col);

                int endRow = Math.min(row + PARTITION_SIZE, rowsCount);
                int endCol = Math.min(col + PARTITION_SIZE, colsCount);
                Point endPoint = new Point(endRow, endCol);

                FindIslandsTask task = new FindIslandsTask(map, startPoint, endPoint);
                taskQueue.push(task);
                LOGGER.debug("Produced task for points: {} {}", startPoint, endPoint);
            }
        }

        LOGGER.info("Produced all tasks");
        shouldRun.set(false);
    }

    private TaskQueue<FindIslandsTask> initializeConsumers(AtomicBoolean shouldRun, Set<Set<Point>> islands) {
        int queueSize = consumersCount * 3 / 2;
        TaskQueue<FindIslandsTask> findIslandsTaskTaskQueue = new TaskQueue<>(queueSize);
        for (int i = 0; i < consumersCount; i++) {
            consumersThreadPool.submit(new FindIslandsTaskConsumer(findIslandsTaskTaskQueue,
                    shouldRun,
                    islands
            ));
        }
        LOGGER.info("Task consumers initialized");
        return findIslandsTaskTaskQueue;
    }

}
