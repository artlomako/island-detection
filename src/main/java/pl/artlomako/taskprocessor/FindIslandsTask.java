package pl.artlomako.taskprocessor;

import pl.artlomako.islanddetection.Point;

public class FindIslandsTask implements Task {
    private final boolean[][] map;
    private final Point startPoint;
    private final Point finishPoint;

    public FindIslandsTask(boolean[][] map, Point startPoint, Point finishPoint) {
        this.map = map;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
    }

    public boolean[][] getMap() {
        return map;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getFinishPoint() {
        return finishPoint;
    }

    @Override
    public String toString() {
        return "FindIslandsTask{" +
                "startPoint=" + startPoint +
                ", finishPoint=" + finishPoint +
                '}';
    }
}
