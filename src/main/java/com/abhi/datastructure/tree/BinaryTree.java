package com.abhi.datastructure.tree;

public class BinaryTree {

	Node head;

	BinaryTree(Node head) {
		this.head = head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(3);
		head.right = new Node(2);
		head.right.left = new Node(5);
		head.right.right = new Node(4);
		BinaryTree tree = new BinaryTree(head);
		display(tree.head);
		mirror(tree.head);
		System.out.println();
		display(tree.head);
	}

	void display() {
		display(this.head);
	}

	static void display(Node n) {
		if (n != null) {
			System.out.print(n.data);
			display(n.left);
			display(n.right);
		}
	}

	void mirror() {
		mirror(this.head);
	}

	static void mirror(Node n) {
		if (n != null) {
			Node leftNode = n.left;
			n.left = n.right;
			n.right = leftNode;
			mirror(n.left);
			mirror(n.right);
		}
	}

	static boolean areMirror(Node a, Node b) {
		/* Base case : Both empty */
		if (a == null && b == null)
			return true;

		// If only one is empty
		if (a == null || b == null)
			return false;

		if (a.data == b.data && areMirror(a.left, b.right) && areMirror(a.right, b.left)) {
			return true;
		}
		return false;
	}
}
