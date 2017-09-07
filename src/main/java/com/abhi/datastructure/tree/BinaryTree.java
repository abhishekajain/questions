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
		BinaryTreeUtil.display(tree.head);
		BinaryTreeUtil.createMirror(tree.head);
		System.out.println();
		BinaryTreeUtil.display(tree.head);
	}

	void display() {
		BinaryTreeUtil.display(this.head);
	}


	void mirror() {
		BinaryTreeUtil.createMirror(this.head);
	}


}
