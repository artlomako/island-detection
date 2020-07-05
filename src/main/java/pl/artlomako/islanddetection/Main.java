package pl.artlomako.islanddetection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artlomako.islanddetection.islandprovider.IslandProvider;
import pl.artlomako.islanddetection.islandprovider.StubIslandProvider;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(LookupTaskProducerFactory.class);

    public static void main(String[] args) {
        IslandProvider islandProvider = new StubIslandProvider();
        boolean[][] island = islandProvider.get();

        long startedAt = System.currentTimeMillis();
        int islandsCount = IslandsLookup.countIslands(island);
        long finishedAt = System.currentTimeMillis();
        long executionTime = finishedAt - startedAt;

        LOGGER.info("Found {} islands in {} milliseconds", islandsCount, executionTime);
    }


}
