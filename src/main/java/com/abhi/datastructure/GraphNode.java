package com.abhi.datastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		int dimension = 0;
		for(GraphNode node: graph){
			int newDimension = node.getNeighbors().size();
			if(dimension<newDimension){
				dimension = newDimension;
			}			
		}
		
		Map<Integer, String> colors = new HashMap<Integer, String>();
		for(int i=0; i<=dimension; i++){
			colors.put(i+1, "color"+1);
		}
    }

}
