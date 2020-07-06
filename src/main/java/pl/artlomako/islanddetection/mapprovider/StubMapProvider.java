package pl.artlomako.islanddetection.mapprovider;

public class StubMapProvider implements MapProvider {
    private static final int[][] ZERO_ONE_SHAPE = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0},
    };

    @Override
    public boolean[][] get() {
        int rowsCount = ZERO_ONE_SHAPE.length;
        int colsCount = ZERO_ONE_SHAPE[0].length;
        boolean[][] booleanShape = new boolean[rowsCount][colsCount];
        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < colsCount; col++) {
                booleanShape[row][col] = ZERO_ONE_SHAPE[row][col] == 1;
            }
        }

        return booleanShape;
    }
}
