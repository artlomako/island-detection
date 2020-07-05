package pl.artlomako.islanddetection.islandprovider;

import java.util.concurrent.ThreadLocalRandom;

public class RandomIslandProvider implements IslandProvider {
    private static final int LAND_DRAWING_CHANCE = 30;
    private final int rowsCount;
    private final int colsCount;

    public RandomIslandProvider(int rowsCount, int colsCount) {
        this.rowsCount = rowsCount;
        this.colsCount = colsCount;
    }

    @Override
    public boolean[][] get() {
        if (rowsCount == 0) {
            return new boolean[][]{};
        }

        boolean[][] map = new boolean[rowsCount][colsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                map[i][j] = getRandomValue();
            }
        }
        return map;
    }

    private boolean getRandomValue() {
        return ThreadLocalRandom.current().nextInt(100) < LAND_DRAWING_CHANCE;
    }
}
