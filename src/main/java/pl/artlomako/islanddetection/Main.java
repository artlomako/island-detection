package pl.artlomako.islanddetection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artlomako.islanddetection.islandprovider.IslandProvider;
import pl.artlomako.islanddetection.islandprovider.RandomIslandProvider;
import pl.artlomako.islanddetection.islandprovider.StubIslandProvider;
import pl.artlomako.islanddetection.islandslookup.ConcurrentIslandsLookup;
import pl.artlomako.islanddetection.islandslookup.IslandsLookup;
import pl.artlomako.islanddetection.islandslookup.SimpleIslandsLookup;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        IslandProvider islandProvider = new StubIslandProvider();

        boolean[][] island = islandProvider.get();

        IslandsLookup islandsLookup = new ConcurrentIslandsLookup(2);
        long startedAt = System.currentTimeMillis();
        int islandsCount = islandsLookup.countIslands(island);
        long finishedAt = System.currentTimeMillis();
        long executionTime = finishedAt - startedAt;

        LOGGER.info("Found {} islands in {} milliseconds", islandsCount, executionTime);
    }


}
