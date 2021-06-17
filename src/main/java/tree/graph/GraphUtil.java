package tree.graph;

import java.util.*;

public class GraphUtil {

    public static List<String> shortestPath(Map<String, String[]> graph, String start, String end){
        return null;
    }

    public static boolean hasPathBFGraph(Map<String, String[]> graph, String start, String end){
        if(!(graph.containsKey(start) && graph.containsKey(end))){
            return false;
        }

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()){
            String current = queue.poll();
            visited.add(current);
            if(current.equals(end)){
                return true;
            }
            String[] adjenctes = graph.get(current);
            for(String node:adjenctes){
                if(!visited.contains(node)){
                    queue.add(node);
                }
            }
        }
        return false;
    }
}
