package tree.graph;

import java.util.*;

public class GraphUtil {

    public static List<String> shortestPath(Map<String, String[]> graph, String start, String end){
        if(!graph.containsKey(start) && !graph.containsKey(end)){
            return null;
        }
        return  bftraversal(graph, start, end);
    }

    static class NodeDistance{
        String node;
        int  distance;

        NodeDistance(String node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public static Map<String, NodeDistance> shortestPathAll(Map<String, String[]> graph, String start){
        Map<String, NodeDistance> result = new HashMap<>();
        result.put(start,  new NodeDistance(start, 0));

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            String current = queue.poll();
            for(String adjucent:graph.get(current)){
                if(!visited.contains(adjucent)){
                    queue.add(adjucent);
                    visited.add(adjucent);
                    result.put(adjucent, new NodeDistance(current, result.get(current).distance+1));
                }
            }
        }
        return result;
    }

    public static String shortestPathAll(Map<String, String[]> graph, String start, String end){
        Map<String, NodeDistance> result = new HashMap<>();
        result.put(start,  new NodeDistance(start, 0));

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()){
            String current = queue.poll();
            for(String adjucent:graph.get(current)){
                if(!visited.contains(adjucent)){
                    queue.add(adjucent);
                    visited.add(adjucent);
                    result.put(adjucent, new NodeDistance(current, result.get(current).distance+1));
                    if(end == adjucent){
                        return printPath(result, start, end);
                    }
                }
            }
        }
        return null;
    }

    public static String printPath(Map<String, NodeDistance> map, String start, String end){
        StringBuilder builder = new StringBuilder();

        String current = end;
        while(current!=start){
            NodeDistance currentParent = map.get(current);
            builder.append(current+">-");
            current = currentParent.node;
        }
        return builder.append(start).reverse().toString();
    }

    public static List<String> bftraversal(Map<String, String[]> graph, String start, String end){
        LinkedList<String> queues = new LinkedList<>();
        Set<String> visiteds = new HashSet<>();
        queues.add(start);
        visiteds.add(start);

        LinkedList<String> queuee = new LinkedList<>();
        Set<String> visitede = new HashSet<>();
        queuee.add(end);
        visitede.add(end);

        while (!queues.isEmpty() && !queuee.isEmpty()){

            List<String> common = isCommon(visitede, visiteds);
            if(common.size() != 0){
                return common;
            }

            String currents = queues.poll();
            String currente = queuee.poll();

            for(String adjecent:graph.get(currents)){
                if(!visiteds.contains(adjecent)){
                    queues.add(adjecent);
                    visiteds.add(adjecent);
                }
            }

            for(String adjecent:graph.get(currente)){
                if(!visitede.contains(adjecent)){
                    queuee.add(adjecent);
                    visitede.add(adjecent);
                }
            }
        }
        return null;
    }

    private static List<String> isCommon(Set<String> source, Set<String> destination){
        int sizeSource = source.size();
        int sizeDestination = destination.size();
        List<String> commons = new ArrayList<>();
        if(sizeSource<sizeDestination){
            for(String element:source){
                if(destination.contains(element)){
                    commons.add(element);
                }
            }
        }else{
            for(String element:destination){
                if(source.contains(element)){
                    commons.add(element);
                }
            }
        }
        return commons;
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
