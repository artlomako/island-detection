package pl.artlomako.islanddetection;

import java.util.HashSet;
import java.util.Set;

public class IslandsLookup {
    public static int countIslands(boolean[][] map) {
        Set<Point> visitedPoints = new HashSet<>();
        int islandsCount = 0;

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                Point point = new Point(row, col);
                boolean notVisited = !visitedPoints.contains(point);
                boolean land = map[row][col];
                if (notVisited && land) {
                    Set<Point> islandPoints = DFS.getVertexes(map, point);
                    visitedPoints.addAll(islandPoints);
                    islandsCount++;
                }
            }
        }
        return islandsCount;
    }
}
