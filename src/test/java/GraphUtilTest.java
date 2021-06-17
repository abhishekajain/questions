import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class GraphUtilTest {

    @Test
    public void testBFS(){
        System.out.println("testBFS>>>");
        Map<Integer, GraphUtil.Node> graph = generateTestGraph();
        System.out.println("bfsPath 1 to 10>>>");
        Assert.assertFalse(GraphUtil.bfsPath(generateTestGraph(), 1, 10));
        System.out.println("dfsPath 1 to 10>>>");
        Assert.assertFalse(GraphUtil.dfsPath(generateTestGraph(), 1, 10));
        System.out.println("<<<testBFS");
    }

    private Map<Integer, GraphUtil.Node> generateTestGraph() {
        Map<Integer, GraphUtil.Node> graph = new HashMap<>();

        int i = 1;
        while(i<=10){
            GraphUtil.Node node = new GraphUtil.Node();
            node.id = i;
            graph.put(i, node);
            i++;
        }
        i=1;
        Random random = new Random();
        while(i<=10){
            GraphUtil.Node node = graph.get(i);
            int j = 0;
            int adjacents = random.nextInt(20);
            while(j<adjacents){
                int k = random.nextInt(10);
                if(k != i && k != 0){
                    node.adjacent.add(graph.get(k));
                    j++;
                }
            }
            i++;
        }

        return graph;
    }

    @Test
    public void testHasBFSPath(){
        System.out.println("testHasBFSPath>>>");
        Map<Integer, GraphUtil.Node> graph = generateTestGraphFixed();
        System.out.println("bfsPath 2 to 6>>>");
        Assert.assertTrue(GraphUtil.bfsPath(graph, 2, 6));
        System.out.println("bfsPath 0 to 7>>>");
        Assert.assertTrue(GraphUtil.bfsPath(graph, 0, 7));
        System.out.println("bfsPath 5 to 1>>>");
        Assert.assertTrue(GraphUtil.bfsPath(graph, 5, 1));
        System.out.println("<<<testHasBFSPath");
    }

    @Test
    public void testHasDFSPath(){
        System.out.println("testHasDFSPath>>>");
        Map<Integer, GraphUtil.Node> graph = generateTestGraphFixed();
        System.out.println("dfsPath 2 to 6>>>");
        Assert.assertTrue(GraphUtil.dfsPath(graph, 2, 6));
        System.out.println("dfsPath 0 to 7>>>");
        Assert.assertTrue(GraphUtil.dfsPath(graph, 0, 7));
        System.out.println("dfsPath 5 to 1>>>");
        Assert.assertTrue(GraphUtil.dfsPath(graph, 5, 1));
        System.out.println("<<<testHasDFSPath");
    }

    @Test
    public void testPrintShortestDistance(){
        System.out.println("testPrintShortestDistance>>>");
        Map<Integer, GraphUtil.Node> graph = generateTestGraphFixed();
        System.out.println("printShortestDistance 2 to 6>>>");
        GraphUtil.printShortestDistance(graph, 2, 6);
        System.out.println("printShortestDistance 0 to 7>>>");
        GraphUtil.printShortestDistance(graph, 0, 7);
        System.out.println("<<<testPrintShortestDistance");
    }
/*
    1 -- 0    7 -- 6
    |    | / | / |
    2    3 -- 4 -- 5
 */
    private Map<Integer, GraphUtil.Node> generateTestGraphFixed() {
        Map<Integer, GraphUtil.Node> graph = new HashMap<>();

        int i = 0;
        while(i<8){
            GraphUtil.Node node = new GraphUtil.Node();
            node.id = i;
            graph.put(i, node);
            i++;
        }

        graph.get(0).adjacent.add(graph.get(3));
        graph.get(0).adjacent.add(graph.get(1));

        graph.get(1).adjacent.add(graph.get(0));
        graph.get(1).adjacent.add(graph.get(2));

        graph.get(2).adjacent.add(graph.get(1));

        graph.get(3).adjacent.add(graph.get(0));
        graph.get(3).adjacent.add(graph.get(7));
        graph.get(3).adjacent.add(graph.get(4));

        graph.get(4).adjacent.add(graph.get(3));
        graph.get(4).adjacent.add(graph.get(7));
        graph.get(4).adjacent.add(graph.get(6));
        graph.get(4).adjacent.add(graph.get(5));

        graph.get(5).adjacent.add(graph.get(6));
        graph.get(5).adjacent.add(graph.get(4));

        graph.get(6).adjacent.add(graph.get(7));
        graph.get(6).adjacent.add(graph.get(4));
        graph.get(6).adjacent.add(graph.get(5));

        graph.get(7).adjacent.add(graph.get(3));
        graph.get(7).adjacent.add(graph.get(4));
        graph.get(7).adjacent.add(graph.get(6));


        return graph;
    }

    @Test
    public void testDFS(){
        System.out.println("testDFS>>>");
        System.out.println("dfsPath 1 to 5 >>>");
        Assert.assertTrue(GraphUtil.dfsPath(generateTestGraph(), 1, 5));
        System.out.println("<<<testDFS");
    }

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = GraphUtil.getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = GraphUtil.getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        GraphUtil.getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        GraphUtil.getPath(getNetwork(), "a", "h");
    }

    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() { {
            put("a", new String[] {"b", "c", "d"});
            put("b", new String[] {"a", "d"});
            put("c", new String[] {"a", "e"});
            put("d", new String[] {"a", "b"});
            put("e", new String[] {"c"});
            put("f", new String[] {"g"});
            put("g", new String[] {"f"});
        }};
    }

    @Test
    public void testfindSmallestRegion(){

        String[][] regions = {
                {"EARTH", "North America", "South Amercia", "Asia"},
                {"North America", "CANADA", "USA", "Mexico"},
                {"USA", "New York", "California", "New Jersey", "Arizona"},
                {"CANADA", "Qubec", "Ontrio"},
                {"Asia", "India", "China", "Nepal"}
        };
        List<List<String>> input = new ArrayList<>();
        for(String[] region: regions){
            input.add(Arrays.asList(region));
        }
        Assert.assertEquals("North America", GraphUtil.findSmallestRegion(input, "New York", "Qubec"));
        Assert.assertEquals("USA", GraphUtil.findSmallestRegion(input, "New York", "California"));
        Assert.assertEquals("California", GraphUtil.findSmallestRegion(input, "California", "California"));
        Assert.assertNull(GraphUtil.findSmallestRegion(input, "California1", "California1"));
    }
}
