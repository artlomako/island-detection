package pl.artlomako.islanddetection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

class IslandsLookupTestCases {
    public static final Map<boolean[][], Integer> MAPS = new HashMap<>();

    static {
        MAPS.put(
                new boolean[][]{
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, false, true},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {true, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, true, true, true, true, true, true, true, true, true, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, true, true, true, true, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, true, false, false, true, false, false, false, false, false, false, true, false, false, false},
                        {true, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, true, false, false, false},
                        {true, true, true, true, true, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false},
                }, 6);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false},
                        {false, false, false, true, false, true, false, false, false, false, true, false, true, false, false, false, false, false, false, false},
                        {false, false, true, false, true, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false},
                        {false, false, false, false, false, true, false, true, false, false, true, false, false, false, true, false, false, false, false, false},
                        {false, false, false, false, false, false, true, false, false, true, false, false, false, false, false, true, false, false, false, false},
                        {false, false, false, false, false, true, false, false, true, false, true, false, true, false, false, false, true, false, false, false},
                        {false, false, false, false, true, false, false, true, false, false, false, true, false, false, false, false, false, true, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                }, 2);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                }, 0);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, true, false, false, false, false, false, false, false, false, false, false, false},
                        {false, true, true, false, false, false, false, false, true, true, false, true, true, false},
                        {false, true, true, true, false, true, true, false, true, true, true, false, false, false},
                        {true, false, true, true, false, true, true, false, false, true, false, false, false, false},
                        {false, false, false, true, true, false, true, true, false, false, false, false, false, false},
                        {false, false, false, false, true, false, true, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                        {false, false, false, false, false, false, false, false, false, false, false, false, false, false},
                }, 2);

        MAPS.put(
                new boolean[][]{
                        {false, true, true, true, true, true, true, true, true, true,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {false, false, false, false, true, true, true, true, true, true,},
                        {true, true, true, true, false, true, true, true, true, true,},
                        {true, true, true, true, true, false, true, true, true, true,},
                        {true, true, true, true, true, false, false, true, true, true,},
                        {true, true, true, true, true, false, false, true, true, true,},
                        {true, true, true, true, true, false, false, true, true, true,},
                        {true, true, true, true, true, false, false, true, true, true,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {true, true, true, true, true, true, true, true, true, true,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {true, true, true, true, true, true, true, true, true, true,},
                        {true, true, true, true, true, true, true, true, true, true,},
                }, 5);

        MAPS.put(
                new boolean[][]{
                        {true, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false, false, false, false, false, false,},
                        {false, true, false, false, false, false, false, false, true, false,},
                        {false, true, false, false, false, false, false, true, false, false,},
                        {false, true, false, false, false, false, true, false, false, false,},
                        {false, true, false, false, false, true, false, false, false, false,},
                        {false, true, false, false, true, false, false, false, false, false,},
                        {false, true, false, true, false, false, false, false, false, false,},
                        {false, true, true, false, false, false, false, false, false, false,},
                        {false, true, true, true, true, true, true, true, true, false,},
                        {false, false, false, false, false, false, false, false, false, false,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {false, false, true, false, false},
                        {false, false, true, false, false},
                        {false, false, true, false, false},
                        {false, false, true, false, false},
                        {false, false, true, false, false,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false},
                        {true, true, false, false, false},
                        {true, true, true, false, false},
                        {true, true, true, false, false},
                        {false, false, false, false, false},
                }, 1);

        MAPS.put(
                new boolean[][]{},
                0);

        MAPS.put(
                new boolean[][]{
                        {false}
                }, 0);

        MAPS.put(
                new boolean[][]{
                        {true}
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, true},
                        {true, true, false, false, false},
                        {true, true, true, false, true},
                        {true, true, true, false, false},
                        {false, false, false, true, true},
                }, 3);

        MAPS.put(
                new boolean[][]{
                        {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false,},
                }, 8);

        MAPS.put(
                new boolean[][]{
                        {false, true, true, true, false},
                        {false, false, false, false, false},
                        {true, true, false, false, false},
                        {false, false, false, true, false},
                        {false, false, false, false, false},
                }, 3);

        MAPS.put(
                new boolean[][]{
                        {true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true,},
                        {true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true,},
                        {true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true,},
                        {true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true,},
                        {true, false, true, false, true, false, true, false, true, false,},
                        {false, true, false, true, false, true, false, true, false, true,},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {true, false, false, false, false},
                        {false, true, false, false, false},
                        {false, false, true, false, false},
                        {false, false, true, false, false},
                        {false, false, false, true, true},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {true, true, true, true, true},
                        {false, true, true, true, true},
                        {false, false, true, true, true},
                        {true, false, true, true, true},
                        {false, false, false, true, true},
                }, 2);

        MAPS.put(
                new boolean[][]{
                        {true, false, false, false, false},
                        {false, true, false, false, false},
                        {false, false, true, false, false},
                        {false, false, true, false, false},
                        {false, false, false, true, true},
                }, 1);

        MAPS.put(
                new boolean[][]{
                        {false, false, false, false, false, false, true, false, false, false, false, false, false},
                        {false, false, false, false, false, true, true, true, false, false, false, false, false},
                        {false, false, false, false, true, true, true, true, true, false, false, false, false},
                        {false, false, false, true, true, true, true, true, true, true, false, false, false},
                        {false, false, true, true, true, true, true, true, true, true, true, false, false},
                        {false, true, true, true, true, true, true, true, true, true, true, true, false},
                }, 1);
    }

    public static boolean[][] generateMap(int rowsCount, int colsCount) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        boolean[][] map = new boolean[rowsCount][colsCount];

        for (int row = 0; row < rowsCount; row++) {
            for (int col = 0; col < colsCount; col++) {
                map[row][col] = random.nextBoolean();
            }
        }
        return map;
    }

}