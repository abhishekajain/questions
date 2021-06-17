package com.abhi;

import java.util.*;

public class Graph {

    Map<Integer, Node> map = new HashMap<>();

    static class Node{
        int id;
        Set<Node> children = new HashSet<>();
        public Node(int id){
            this.id = id;
        }
    }

    public Node getNode(int id){
        if(this.map.containsKey(id)){
            return this.map.get(id);
        }
        return null;
    }

    boolean hasPathDF(Node startNode, Node endNode){

        return false;
    }

    boolean hasPathBF(Node startNode, Node endNode){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(startNode.id);
        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()){
            Integer currentNodeId = queue.poll();
            visited.add(currentNodeId);
            if(currentNodeId == endNode.id){
                return true;
            }
            Node currentNode = this.map.get(currentNodeId);
            for(Node child:currentNode.children){
                if(!visited.contains(child.id)){
                    queue.add(child.id);
                }
            }
        }
        return false;
    }


}
