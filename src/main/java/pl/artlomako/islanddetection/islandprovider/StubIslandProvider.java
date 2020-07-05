package pl.artlomako.islanddetection.islandprovider;

public class StubIslandProvider implements IslandProvider {
    @Override
    public boolean[][] get() {
        return new boolean[][]{
                {false, false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, false, false},
                {true, true, true, false, false, false, true, false, false},
                {true, true, false, false, false, true, true, true, false},
                {false, false, false, false, false, true, true, false, false},
                {false, false, true, false, false, false, false, false, false},
                {true, true, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, true, false, false},
        };
    }
}
