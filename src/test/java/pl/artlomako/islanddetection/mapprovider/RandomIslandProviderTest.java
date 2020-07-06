package pl.artlomako.islanddetection.mapprovider;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomIslandProviderTest {

    @Test
    public void shouldGenerateEmptyArray_whenZeroRowsCountGiven() {
        // given
        int rowsCount = 0;
        int colsCount = 10;

        // when
        RandomMapProvider islandProvider = new RandomMapProvider(rowsCount, colsCount);
        boolean[][] island = islandProvider.get();

        // then
        Assertions.assertThat(island.length).isEqualTo(rowsCount);
    }

    @Test
    public void shouldGenerateArrayWithEmptyRows_whenZeroColsCountGiven() {
        // given
        int rowsCount = 10;
        int colsCount = 0;

        // when
        RandomMapProvider islandProvider = new RandomMapProvider(rowsCount, colsCount);
        boolean[][] island = islandProvider.get();

        // then
        Assertions.assertThat(island.length).isEqualTo(rowsCount);
        Assertions.assertThat(island[0].length).isEqualTo(colsCount);
    }

    @Test
    public void shouldGenerateArrayWithGivenDimensions_whenNonZeroDimensionsGiven() {
        // given
        int rowsCount = 10;
        int colsCount = 20;

        // when
        RandomMapProvider islandProvider = new RandomMapProvider(rowsCount, colsCount);
        boolean[][] island = islandProvider.get();

        // then
        Assertions.assertThat(island.length).isEqualTo(rowsCount);
        Assertions.assertThat(island[0].length).isEqualTo(colsCount);
    }

}