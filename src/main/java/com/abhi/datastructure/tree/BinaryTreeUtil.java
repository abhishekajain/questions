package com.abhi.datastructure.tree;

public class BinaryTreeUtil {

	// A tree where no leaf is much farther away from the root than any other
	// leaf. Different balancing schemes allow different definitions of much
	// farther and different amounts of work to keep them balanced.
	//
	// Consider a height-balancing scheme where following conditions should be
	// checked to determine if a binary tree is balanced.
	// An empty tree is height-balanced. A non-empty binary tree T is balanced
	// if:
	// 1) Left subtree of T is balanced
	// 2) Right subtree of T is balanced
	// 3) The difference between heights of left subtree and right subtree is
	// not more than 1.

	public static boolean isHeightBalanced(Node node) {
		//base case
		if(node == null){
			return true;
		}
		
		int lH = height(node.left);
		int rH = height(node.right);

		//check id difference in height is not more then one and
		// left and right sub trees are height balanced.
		if(Math.abs(lH-rH) <= 1 
				&& isHeightBalanced(node.left) 
				&& isHeightBalanced(node.right)){
			return true;
		}

		return false;
	}
	
	public static int height(Node node){
		//base case
		if(node == null){
			return 0;
		}
		//otherwise calculate height by adding one for this node and find max of left or right node
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	public static void createMirror(Node node){
		if(node != null){
			Node leftNode = node.left;
			node.left = node.right;
			node.right = leftNode;
			createMirror(node.left);
			createMirror(node.right);
		}
	}
	
	public static void display(Node node){
		if(node != null){
			display(node.left);
			System.out.print(node.data+"-->");
			display(node.right);
		}
	}
	
	public static boolean isMirror(Node nodeA, Node nodeB){
		//if both nodes are null, node are mirror
		if(nodeA == null && nodeB == null){
			return true;
		}
		//if only one node is null nodes are not mirror 
		if(nodeA == null || nodeB == null){
			return false;
		}
		
		//if both node not null but data are equal check left and right subtree of each node
		if(nodeA.data == nodeB.data 
				&& isMirror(nodeA.left, nodeB.right) 
				&& isMirror(nodeA.right, nodeB.left)){
			return true;
		}
		return false;
	}

}
