package com.abhi.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class NTree {

	@Test
	public void test() {

		Node head = new Node("1", "1");

		Node child2 = new Node("2", "2");
		Node child3 = new Node("3", "3");

		Node[] children = { child2, child3 };

		head.childs = children;

		Node child4 = new Node("4", "2");
		Node child5 = new Node("5", "3");

		Node[] children2 = { child4, child5 };

		child2.childs = children2;

		traverse(head);
		traverseDFS(head);

	}

	static class Node {
		Node[] childs;
		String path;
		String md5sum;

		Node(String path, String md5sum) {
			this.path = path;
			this.md5sum = md5sum;
			childs = null;
		}

	}

	static void traverseDFS(Node node) {
		if (node != null) {
			System.out.println(node.path);
			if (node.childs != null) {
				for (Node chlid : node.childs) {
					traverseDFS(chlid);
				}
			}
		}
	}

	static void traverse(Node node) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			System.out.println(n.path);
			if (n.childs != null) {
				for (Node chlid : n.childs) {
					queue.add(chlid);
				}
			}
		}
	}
}
