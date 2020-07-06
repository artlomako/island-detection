package pl.artlomako.islanddetection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.artlomako.islanddetection.mapprovider.MapProvider;
import pl.artlomako.islanddetection.mapprovider.StubMapProvider;
import pl.artlomako.islanddetection.islandslookup.ConcurrentIslandsLookup;
import pl.artlomako.islanddetection.islandslookup.IslandsLookup;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        MapProvider mapProvider = new StubMapProvider();

        boolean[][] map = mapProvider.get();

        IslandsLookup islandsLookup = new ConcurrentIslandsLookup(2);
        long startedAt = System.currentTimeMillis();
        int islandsCount = islandsLookup.countIslands(map);
        long finishedAt = System.currentTimeMillis();
        long executionTime = finishedAt - startedAt;

        LOGGER.info("Found {} islands in {} milliseconds", islandsCount, executionTime);
    }


}
