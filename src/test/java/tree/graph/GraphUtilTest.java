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
        String[] nodesB = {"A", "E", "C", "D"};
        graph.put("B", nodesB);
        String[] nodesC = {"A", "D"};
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
        List<String> common = GraphUtil.shortestPath(GraphUtilTest.graph, "A", "F");
        Assert.assertNotNull(common);
    }

    @Test
    public void testshortestPathAll(){
        GraphUtil.shortestPathAll(graph, "A");
    }

    @Test
    public void testshortestPathAll2(){
        Map<String, String[]> graphc = new HashMap<>();


        String[] nodesA = {"B", "D"};
        graphc.put("A", nodesA);
        String[] nodesB = {"E", "D"};
        graphc.put("B", nodesB);
        String[] nodesC = {"A", "F"};
        graphc.put("C", nodesC);
        String[] nodesD = {"G", "F"};
        graphc.put("D", nodesD);
        String[] nodesE = {"G"};
        graphc.put("E", nodesE);
        String[] nodesF = {};
        graphc.put("F", nodesF);
        String[] nodesG = {"F"};
        graphc.put("G", nodesG);

        Map<String, GraphUtil.NodeDistance> result1 = GraphUtil.shortestPathAll(graphc, "C");
        Assert.assertEquals("C->A->B->E",  GraphUtil.shortestPathAll(graphc, "C", "E"));
        Assert.assertNull(GraphUtil.shortestPathAll(graphc, "D", "E"));
        Assert.assertEquals("C->A->D",  GraphUtil.shortestPathAll(graphc, "C", "D"));
        Assert.assertEquals("C->A->D->G",  GraphUtil.shortestPathAll(graphc, "C", "G"));
    }

    @Test
    public void testHasPathBFGraph(){
        Assert.assertTrue(GraphUtil.hasPathBFGraph(GraphUtilTest.graph, "C", "F"));
    }
}
