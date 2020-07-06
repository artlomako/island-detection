package pl.artlomako.islanddetection.mapprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMapProvider implements MapProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(RandomMapProvider.class);

    private static final int LAND_DRAWING_CHANCE = 30;
    private final int rowsCount;
    private final int colsCount;

    public RandomMapProvider(int rowsCount, int colsCount) {
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

        LOGGER.info("Generated [{},{}] map", rowsCount, colsCount);

        return map;
    }

    private boolean getRandomValue() {
        return ThreadLocalRandom.current().nextInt(100) < LAND_DRAWING_CHANCE;
    }
}
