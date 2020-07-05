package pl.artlomako.taskprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artlomako.islanddetection.DFS;
import pl.artlomako.islanddetection.Point;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class FindIslandsTaskConsumer implements TaskConsumer<FindIslandsTask> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindIslandsTaskConsumer.class);

    private final AtomicBoolean shouldRun;
    private final Set<Point> visitedPoints;
    private final Set<Set<Point>> islands;
    private final Set<Set<Point>> globalIslands;
    private final TaskQueue<FindIslandsTask> taskQueue;

    public FindIslandsTaskConsumer(TaskQueue<FindIslandsTask> taskQueue,
                                   AtomicBoolean shouldRun,
                                   Set<Set<Point>> globalIslands) {
        this.taskQueue = taskQueue;
        this.shouldRun = shouldRun;
        this.globalIslands = globalIslands;
        this.visitedPoints = new HashSet<>();
        this.islands = new HashSet<>();
    }

    @Override
    public void run() {
        LOGGER.info("Consumer started");

        while (shouldRun.get() || !taskQueue.isEmpty()) {
            Optional<FindIslandsTask> taskOptional = taskQueue.pop();
            if (taskOptional.isEmpty()) {
                LOGGER.debug("Obtained empty task from queue");
                continue;
            }

            FindIslandsTask task = taskOptional.get();
            LOGGER.debug("Task obtained {}", task);

            boolean[][] map = task.getMap();
            Point startPoint = task.getStartPoint();
            Point finishPoint = task.getFinishPoint();

            for (int row = startPoint.getRow(); row < finishPoint.getRow(); row++) {
                for (int col = startPoint.getCol(); col < finishPoint.getCol(); col++) {
                    Point point = new Point(row, col);

                    boolean land = map[row][col];
                    boolean notVisited = !visitedPoints.contains(point);
                    if (land && notVisited) {
                        Set<Point> landPoints = DFS.getVertexes(map, point);
                        islands.add(landPoints);
                        visitedPoints.addAll(landPoints);
                        cleanupAndSynchronizeVisitedSets();
                    }
                }
            }
        }

        synchronizeGlobalIslands();
    }

    private void cleanupAndSynchronizeVisitedSets() {
        if (visitedPoints.size() > 1000000) {
            visitedPoints.clear();
        }

        if (islands.size() > 2000) {
            synchronizeGlobalIslands();
            islands.clear();
        }
    }

    private boolean synchronizeGlobalIslands() {
        return globalIslands.addAll(islands);
    }
}
