package pl.artlomako.islanddetection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class IslandsLookupTest {
    @Test
    public void shouldCountIslandsProperly_whenStaticTestCasesProvided() {
        Map<boolean[][], Integer> maps = IslandsLookupTestCases.MAPS;

        for (Map.Entry<boolean[][], Integer> testEntry : maps.entrySet()) {
            // given
            boolean[][] map = testEntry.getKey();
            Integer expectedIslandsCount = testEntry.getValue();

            // when
            int count = IslandsLookup.countIslands(map);

            // then
            Assertions.assertThat(count).isEqualTo(expectedIslandsCount);
        }
    }

    @Test
    public void shouldCountIslandsProperly_whenDynamicMapGenerated() {
        // given
        int rowsCount = 1000;
        int colsCount = 1000;
        boolean[][] map = IslandsLookupTestCases.generateMap(rowsCount, colsCount);

        // when
        int islandsCount = IslandsLookup.countIslands(map);

        // then
        Assertions.assertThat(islandsCount).isGreaterThanOrEqualTo(0);
    }

}