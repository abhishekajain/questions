import java.util.*;

public class GraphUtil {

    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        List<String> previous = new ArrayList<>();
        if(!bfsMapPath(graph,startNode,endNode, previous)){
            return null;
        }
        return previous.toArray(new String[0]);
    }

    private static boolean bfsMapPath(Map<String, String[]> graph, String startNode, String endNode, List<String> previous){
        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
            throw new IllegalArgumentException("Node is not in the graph");
        }
        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        queue.offer(startNode);
        visited.add(startNode);
        previous.add(startNode);
        if(startNode.equals(endNode)){
            return true;
        }
        while(!queue.isEmpty()){
            String currentNode = queue.poll();
            for(String node:graph.get(currentNode)){
                if(!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                    if(!previous.contains(currentNode)) {
                        previous.add(currentNode);
                    }
                    if(node.equals(endNode)){
                        previous.add(endNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class Node{
        Integer id;
        Set<Node> adjacent = new HashSet<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static boolean bfsPath(Map<Integer, Node> graph, Integer start, Integer end){
        if(graph.size()<1 && !graph.containsKey(start) && !graph.containsKey(end)){
            throw new RuntimeException();
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(graph.get(start));
        visited.add(graph.get(start));
        while (!queue.isEmpty()){
            Node currentNode = queue.poll();
            System.out.print(currentNode.id+"-->");
            if(end == currentNode.id){
                return true;
            }
            for(Node node:currentNode.adjacent){
                if(!visited.contains(node)){
                    queue.offer(node);
                    visited.add(node);
                }
            }
        }
        return false;
    }

    public static boolean dfsPath(Map<Integer, Node> graph, Integer start, Integer end){
        Set<Node> visited = new HashSet<>();
        return dfsPath(graph, start, end, visited);
    }

    private static boolean dfsPath(Map<Integer, Node> graph, Integer current, Integer end, Set<Node> visited){
        Node currentNode = graph.get(current);
        visited.add(currentNode);
        System.out.print(currentNode.id+"-->");
        if(currentNode.id == end){
            return true;
        }
        for(Node node:currentNode.adjacent){
            if(visited.contains(node)){
                continue;
            }
            if(dfsPath(graph, node.id, end, visited)){
                return true;
            }
        }
        return false;
    }

    public static Node[] shortestPath(Map<Integer, Node> graph, Integer start, Integer end){
        Set<Node> visited = new HashSet<>();
        return null;
    }


    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public static void printShortestDistance(Map<Integer, Node> graph, int s, int dest) {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        Map<Integer, Node> pred = new HashMap<>();
        int dist[] = new int[graph.size()];

        if (BFS(graph, s, dest, pred, dist) == false) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return;
        }

        // LinkedList to store path
        LinkedList<Node> path = new LinkedList<>();
        int crawl = dest;
        path.add(graph.get(crawl));
        while (pred.containsKey(crawl)) {
            path.add(pred.get(crawl));
            crawl = pred.get(crawl).id;
        }

        // Print distance
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is ::");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i).id + " ");
        }
    }



    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(Map<Integer, Node> graph, int src,
                               int dest, Map<Integer, Node> pred, int dist[])
    {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        Queue<Node> queue = new LinkedList<Node>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        Set<Node> visited = new HashSet<>();

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < graph.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited.add(graph.get(src));
        dist[src] = 0;
        queue.add(graph.get(src));

        // bfs Algorithm
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            for (Node node:currentNode.adjacent) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    dist[node.id] = dist[currentNode.id] + 1;
                    pred.put(node.id, currentNode);
                    queue.add(node);

                    // stopping condition (when we find
                    // our destination)
                    if (node.id == dest)
                        return true;
                }
            }
        }
        return false;
    }

    public static class TreeNode{
        public  int frequency; // the frequency of this tree
        public  char data;//'\u0000'
        public  TreeNode left, right;
    }
    public static String decode(String s, TreeNode root) {

        StringBuilder builder = new StringBuilder();
        int i = 0;
        TreeNode current = root;
        while(i<s.length()){
            char iChar = s.charAt(i);
            if(iChar == '0'){
                current = current.left;
            }else{
                current = current.right;
            }
            if(current.left == null && current.right == null){
                builder.append(current.data);
                current = root;
            }
            i++;
        }
        return builder.toString();

    }

    /**
     * regions = [
     * ["EARTH", "North America", "South Amercia"],
     * ["North America", "CANADA", "USA"],
     * ["USA", "New York", "California"],
     * ["CANADA", "Qubec", "Ontrio"]
     * ]
     * region1  New York
     * region2  Qubec
     * return North America
     * @param regions
     * @param region1
     * @param region2
     * @return
     */
    public static String findSmallestRegion(List<List<String>> regions, String region1, String region2){
        Map<String, NTreeNode> map = convertToMap(regions);

        NTreeNode root = map.get(regions.get(0).get(0));

        NTreeNode node =  findPath(root, region1, region2);
        if(node == null){
            return null;
        }
        return node.id;
    }

    private static NTreeNode findPath(NTreeNode node, String r1, String r2){
        if(node == null){
            return null;
        }
        if(node.id.equals(r1) || node.id.equals(r2)){
            return node;
        }
        if(node.childern != null){//if nothing null retrun parent, otherwise return child
            List<NTreeNode> notNullPath = new ArrayList<>();//this is going to be both found(2), one found(1) and not found
            for(NTreeNode childNode:node.childern){
                NTreeNode nodePath = findPath(childNode, r1, r2);
                if(nodePath != null){
                    notNullPath.add(nodePath);
                }
            }
            if(notNullPath.size() == 1){
                return notNullPath.get(0);
            }else if(notNullPath.size() == 0){
                return null;
            }else{
                return node;
            }
        }else{
            return null;
        }
//        return node;
    }

//
    private static Map<String, NTreeNode> convertToMap(List<List<String>> regions){
        Map<String, NTreeNode> map = new HashMap<>();
        Set<NTreeNode> nodes = new HashSet<>();
        //map of parents
        for(List<String> region:regions){
            NTreeNode node = new NTreeNode();
            node.id = region.get(0);
            node.childern = new HashSet<>();
            map.put(node.id, node);
            nodes.add(node);
        }
        //populate children
        for(List<String> region:regions){
            Set<NTreeNode> childern = map.get(region.get(0)).childern;
            int i = 1;
            while(i<region.size()){
                String childRegion = region.get(i);
                if(map.containsKey(childRegion)){
                    childern.add(map.get(childRegion));
                }else{//child region that does not have children
                    NTreeNode node = new NTreeNode();
                    node.id = childRegion;
                    childern.add(node);
                    nodes.add(node);
                }
                i++;
            }
        }

        return map;
    }



    static class NTreeNode{
        String id = null;
        Set<NTreeNode> childern = null;
        NTreeNode parent = null;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NTreeNode nTreeNode = (NTreeNode) o;
            return Objects.equals(id, nTreeNode.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return id;
        }
    }
}


