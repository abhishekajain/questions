package com.abhi.datastructure.tree;

import org.junit.Test;

public class BinarySearchTree {

	private Element head;

	public BinarySearchTree() {
		this.head = null;
	}

	public int minimumDepth() {
		return minimumDepth(head);
	}

	public static int minimumDepth(Element element) {
		if (element == null) {
			return 0;
		}
		if (element.right == null && element.left == null) {
			return 1;

		}

		if (element.left == null) {
			return minimumDepth(element.right);
		}

		if (element.right == null) {
			return minimumDepth(element.left);
		}

		return Math.min(minimumDepth(element.right), minimumDepth(element.left)) + 1;
	}

	public int minDepth(Element element) {
		if (element == null)
			return 0;
		return Math.min(minDepth(element.left), minDepth(element.right)) + 1;

	}

	@Test
	public void testMinimumDepth() {
		BinarySearchTree tree = new BinarySearchTree();
		tree.head = new Element(1);
		tree.head.left = new Element(2);
		tree.head.right = new Element(3);
		tree.head.left.left = new Element(4);
		tree.head.left.right = new Element(5);
		tree.head.left.left.left = new Element(6);

		System.out.println(tree.minimumDepth());
		
		System.out.println(tree.minDepth(tree.head));


	}

	public int depth(Element e1, Element e2) {
		return 1;
	}

	public boolean find(int elementValue) {
		Element current = head;
		while (current != null) {
			if (current.value == elementValue) {
				return true;
			} else if (current.value > elementValue) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void insert(int elementValue) {
		Element newNode = new Element(elementValue);
		if (head == null) {
			head = newNode;
			return;
		}
		Element current = head;
		Element parent = null;
		while (true) {
			parent = current;
			if (elementValue < current.value) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void display() {
		display(head);
	}

	// DFS display
	public static void display(Element root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.value);
			display(root.right);
		}
	}

	static class Element {
		int value;
		Element right;
		Element left;

		Element(int value) {
			this.value = value;
			this.right = null;
			this.left = null;
		}
	}
}
