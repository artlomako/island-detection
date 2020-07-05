package pl.artlomako.islanddetection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.artlomako.islanddetection.islandslookup.SimpleIslandsLookup;

import java.util.Map;

class SimpleIslandsLookupTest {
    @Test
    public void shouldCountIslandsProperly_whenStaticTestCasesProvided() {
        Map<boolean[][], Integer> maps = IslandsLookupTestCases.MAPS;

        for (Map.Entry<boolean[][], Integer> testEntry : maps.entrySet()) {
            // given
            boolean[][] map = testEntry.getKey();
            Integer expectedIslandsCount = testEntry.getValue();

            // when
            int count = new SimpleIslandsLookup().countIslands(map);

            // then
            Assertions.assertThat(count).isEqualTo(expectedIslandsCount);
        }
    }

    @Test
    public void shouldCountIslandsProperly_whenDynamicMapGenerated() {
        // given
        int rowsCount = 100;
        int colsCount = 100;
        boolean[][] map = IslandsLookupTestCases.generateMap(rowsCount, colsCount);

        // when
        int islandsCount = new SimpleIslandsLookup().countIslands(map);

        // then
        Assertions.assertThat(islandsCount).isGreaterThanOrEqualTo(0);
    }

}