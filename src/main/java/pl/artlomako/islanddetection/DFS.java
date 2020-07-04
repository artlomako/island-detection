package pl.artlomako.islanddetection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DFS {

    public static Set<Point> getVertexes(boolean[][] map, Point startVertex) {
        if (!map[startVertex.getRow()][startVertex.getCol()]) {
            throw new IllegalArgumentException("Start vertex should be graph vertex");
        }

        Set<Point> visitedVertexes = new HashSet<>();
        Queue<Point> vertexesToCheck = new LinkedList<>();
        vertexesToCheck.add(startVertex);

        while (!vertexesToCheck.isEmpty()) {
            Point vertexToCheck = vertexesToCheck.poll();
            if (visitedVertexes.contains(vertexToCheck)) {
                continue;
            }

            visitedVertexes.add(vertexToCheck);

            Set<Point> adjacentVertexes = getAdjacentVertexes(map, vertexToCheck);
            vertexesToCheck.addAll(adjacentVertexes);
        }
        return visitedVertexes;
    }

    private static Set<Point> getAdjacentVertexes(boolean[][] map, Point currentPoint) {
        Set<Point> result = new HashSet<>();

        int currentRow = currentPoint.getRow();
        int currentCol = currentPoint.getCol();

        boolean canGoTop = currentRow > 0;
        boolean canGoRight = currentCol < map[0].length - 1;
        boolean canGoBottom = currentRow < map.length - 1;
        boolean canGoLeft = currentCol > 0;

        if (canGoTop) {
            int topRow = currentRow - 1;
            if (map[topRow][currentCol]) {
                result.add(new Point(topRow, currentCol));
            }
        }

        if (canGoTop && canGoRight) {
            int topRightRow = currentRow - 1;
            int topRightCol = currentCol + 1;
            if (map[topRightRow][topRightCol]) {
                result.add(new Point(topRightRow, topRightCol));
            }
        }

        if (canGoRight) {
            int rightCol = currentCol + 1;
            if (map[currentRow][rightCol]) {
                result.add(new Point(currentRow, rightCol));
            }
        }

        if (canGoBottom && canGoRight) {
            int rightBottomRow = currentRow + 1;
            int rightBottomCol = currentCol + 1;
            if (map[rightBottomRow][rightBottomCol]) {
                result.add(new Point(rightBottomRow, rightBottomCol));
            }
        }

        if (canGoBottom) {
            int bottomRow = currentRow + 1;
            if (map[bottomRow][currentCol]) {
                result.add(new Point(bottomRow, currentCol));
            }
        }

        if (canGoBottom && canGoLeft) {
            int bottomLeftRow = currentRow + 1;
            int bottomLeftCol = currentCol - 1;
            if (map[bottomLeftRow][bottomLeftCol]) {
                result.add(new Point(bottomLeftRow, bottomLeftCol));
            }
        }

        if (canGoLeft) {
            int leftCol = currentCol - 1;
            if (map[currentRow][leftCol]) {
                result.add(new Point(currentRow, leftCol));
            }
        }

        if (canGoTop && canGoLeft) {
            int topLeftRow = currentRow - 1;
            int topLeftCol = currentCol - 1;
            if (map[topLeftRow][topLeftCol]) {
                result.add(new Point(topLeftRow, topLeftCol));
            }
        }

        return result;
    }

}
