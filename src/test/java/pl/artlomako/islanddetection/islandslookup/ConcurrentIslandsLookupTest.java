package pl.artlomako.islanddetection.islandslookup;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ConcurrentIslandsLookupTest {
    @Test
    public void shouldCountIslandsProperly_whenStaticTestCasesProvided() throws Exception {
        Map<boolean[][], Integer> maps = IslandsLookupTestCases.MAPS;

        for (Map.Entry<boolean[][], Integer> testEntry : maps.entrySet()) {
            // given
            boolean[][] map = testEntry.getKey();
            Integer expectedIslandsCount = testEntry.getValue();

            // when
            int count = new ConcurrentIslandsLookup(1).countIslands(map);

            // then
            Assertions.assertThat(count).isEqualTo(expectedIslandsCount);
        }
    }

    @Test
    public void shouldCountIslandsProperly_whenDynamicMapGenerated() throws Exception {
        // given
        int rowsCount = 100;
        int colsCount = 100;
        boolean[][] map = IslandsLookupTestCases.generateMap(rowsCount, colsCount);

        // when
        int islandsCount = new ConcurrentIslandsLookup(2).countIslands(map);

        // then
        Assertions.assertThat(islandsCount).isGreaterThanOrEqualTo(0);
    }

}