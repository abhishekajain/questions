package com.abhi.datastructure.tree;

import java.util.LinkedList;

import org.junit.Test;

//This class represents a directed graph using adjacency list
//representation
class Graph {
	private int V; // No. of vertices or node
	private LinkedList<Integer>[] adj; // Adjacency Lists or array of nodes
										// adjacent to each node or vertex

	// Constructor
	@SuppressWarnings("unchecked")
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] visited = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue or add it
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			// Dequeue or poll or remove top vertex or node from queue and print
			// it
			s = queue.poll(); // or queue.remove will give same effect
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue or add it
			LinkedList<Integer> i = adj[s];
			i.stream().forEach(n -> {
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			});
		}
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		LinkedList<Integer> i = adj[v];
		i.stream().forEach(n -> {
			if (!visited[n])
				DFSUtil(n, visited);
		});
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS() {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = 0; i < V; ++i)
			if (visited[i] == false)
				DFSUtil(i, visited);
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	@Test
	public static void test() {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
		g.BFS(2);
		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex root)");
		g.DFS();
		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex 2)");
		g.DFS(2);
	}
}
