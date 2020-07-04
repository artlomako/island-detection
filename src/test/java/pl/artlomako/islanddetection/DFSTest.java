package pl.artlomako.islanddetection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class DFSTest {

    @Test
    public void shouldReturnGraphVertexes_whenGraphGiven() {
        // given
        boolean[][] graph = new boolean[][]{
                {true, false, false, false},
                {false, true, true, false},
                {false, false, true, false},
                {false, false, false, true},
        };

        List<Point> expectedVertexes = Arrays.asList(
                new Point(0, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 3)
        );
        // when
        Set<Point> vertexes = DFS.getVertexes(graph, new Point(0, 0));
        // then
        Assertions.assertThat(vertexes).containsAll(expectedVertexes);
    }

    @Test
    public void shouldReturnSingleVertex_whenGraphWithSingleVertexGiven() {
        // given
        boolean[][] graph = new boolean[][]{
                {false, false, true, false},
        };

        List<Point> expectedVertexes = Collections.singletonList(
                new Point(0, 2)
        );
        // when
        Set<Point> vertexes = DFS.getVertexes(graph, new Point(0, 2));
        // then
        Assertions.assertThat(vertexes).containsAll(expectedVertexes);
    }

    @Test
    public void exceptionShouldBeThrown_whenStartPointIsNotGraphVertex() {
        // given
        boolean[][] graph = new boolean[][]{
                {true, false, false, false},
                {false, true, true, false},
                {false, false, true, false},
                {false, false, false, true},
        };
        // when
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> DFS.getVertexes(graph, new Point(0, 1)));
    }

}