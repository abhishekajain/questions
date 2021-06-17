package com.abhi;

import java.util.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class GraphUtil {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
            throw new RuntimeException();
        }


        return bfs(graph, startNode, endNode);
    }

    static String[] bfs(Map<String, String[]> graph, String startNode, String endNode){

        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
            throw new RuntimeException();
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startNode);
        List<String> visited = new ArrayList<>();

        while(!queue.isEmpty()){
            String currentNodeId = queue.poll();
            visited.add(currentNodeId);
            if(currentNodeId == endNode){
                return visited.toArray(new String[0]);
            }
            for(String child:graph.get(currentNodeId)){
                if(!visited.contains(child) && !queue.contains(child)){
                    queue.add(child);
                }
            }
        }
        return null;
    }

    static boolean hasDFSPath(Map<String, String[]> graph, String currentNode, String endNode, List<String> visited) {
        if(visited.contains(currentNode)){
            return false;
        }
        visited.add(currentNode);
        if(currentNode == endNode){
            return true;
        }
        for(String child:graph.get(currentNode)){
            if(hasDFSPath(graph, child, endNode, visited)){
                return true;
            }
        }
        return false;
    }


    @Test
    public void twoHopHasPath1Test() {
        List<String> visited = new ArrayList<String>();
        final boolean actual = hasDFSPath(getNetwork(), "a", "e", visited);
        assert actual;
    }








    // tests

    @Test
    public void twoHopPath1Test() {
        final String[] expected = {"a", "c", "e"};
        final String[] actual = getPath(getNetwork(), "a", "e");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoHopPath2Test() {
        final String[] expected = {"d", "a", "c"};
        final String[] actual = getPath(getNetwork(), "d", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath1Test() {
        final String[] expected = {"a", "c"};
        final String[] actual = getPath(getNetwork(), "a", "c");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath2Test() {
        final String[] expected = {"f", "g"};
        final String[] actual = getPath(getNetwork(), "f", "g");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneHopPath3Test() {
        final String[] expected = {"g", "f"};
        final String[] actual = getPath(getNetwork(), "g", "f");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroHopPath() {
        final String[] expected = {"a"};
        final String[] actual = getPath(getNetwork(), "a", "a");
        assertNotNull(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noPathTest() {
        final String[] actual = getPath(getNetwork(), "a", "f");
        assertNull(actual);
    }

    @Test(expected = Exception.class)
    public void startNodeNotPresentTest() {
        getPath(getNetwork(), "h", "a");
    }

    @Test(expected = Exception.class)
    public void endNodeNotPresentTest() {
        getPath(getNetwork(), "a", "h");
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

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(GraphUtil.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}