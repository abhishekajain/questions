package tree.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphUtilTest {

    static Map<String, String[]> graph = new HashMap<>();

    static {
        String[] nodesA = {"B", "C"};
        graph.put("A", nodesA);
        String[] nodesB = {"C", "D"};
        graph.put("B", nodesB);
        String[] nodesC = {"A", "B", "D"};
        graph.put("C", nodesC);
        String[] nodesD = {"B", "C", "F"};
        graph.put("D", nodesD);
        String[] nodesE = {"B"};
        graph.put("E", nodesE);
        String[] nodesF = {"D"};
        graph.put("F", nodesF);
    }

    @Test
    public void testShortestPath(){
        GraphUtil.shortestPath(GraphUtilTest.graph, "C", "F");
    }

    @Test
    public void testHasPathBFGraph(){
        Assert.assertTrue(GraphUtil.hasPathBFGraph(GraphUtilTest.graph, "C", "F"));
    }
}
