package com.abhi.datastructure.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GraphNode {
	
	private String label;
    private Set<GraphNode> neighbors;
    private Optional<String> color;

    public GraphNode(String label) {
        this.label = label;
        neighbors = new HashSet<GraphNode>();
        color = Optional.empty();
    }

    public String getLabel() {
        return label;
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public boolean hasColor() {
        return color.isPresent();
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color = Optional.ofNullable(color);
    }

    public static void main(String[] args){

		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		
		a.addNeighbor(b);
		b.addNeighbor(a);
		b.addNeighbor(c);
		c.addNeighbor(b);
		
		List<GraphNode> graph = Arrays.asList(a, b, c);
		//get the graph dimension based on how many neighbors maximum it can have
		int dimension = 0;
		for(GraphNode node: graph){
			int newDimension = node.getNeighbors().size();
			if(dimension<newDimension){
				dimension = newDimension;
			}			
		}
		//create list of legal colors 
		List<String> legalColors = new ArrayList<String>();
		for(int i=0; i<=dimension; i++){
			legalColors.add("color"+i);
		}
		
		colorGraph(graph, legalColors);
    }
    
    
    public static void colorGraph(List<GraphNode> graph, List<String> colors) {

        for (GraphNode node : graph) {
        	if(!node.hasColor()){
	            Set<GraphNode> neighbors = node.getNeighbors();
	
	            if (neighbors.contains(node)) {
	                throw new RuntimeException("Node with loop :" + node.getLabel());
	            }
	            
	            // get the node's neighbors' colors, and create a set, later will remove these colors from coloring.
	            Set<String> illegalColors = new HashSet<>();
	            for (GraphNode neighbor : neighbors) {
	                if (neighbor.hasColor()) {
	                    illegalColors.add(neighbor.getColor());
	                }
	            }
	
	            // assign color
	            for (String color : colors) {
	                if (!illegalColors.contains(color)) {
	                    node.setColor(color);
	                    break;
	                }
	            }
        	}
        }
    }

}
