package com.abhi.example;

/**
 * Write a function to see if a binary tree is "superbalanced" (a new tree
 * property we just made up). A tree is "superbalanced" if the difference
 * between the depths of any two leaf nodes is no greater than one.
 * 
 * To check if a tree is height-balanced, get the height of left and right
 * subtrees. Return true if difference between heights is not more than 1 and
 * left and right subtrees are balanced, otherwise return false.
 * 
 * @author abhishek.ajain
 *
 */
public class TreeBalancer {
	
	public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        BinaryTreeNode nodeLeft = tree.root.insertLeft(2);
        BinaryTreeNode nodeRight = tree.root.insertRight(3);
        nodeLeft.insertLeft(4);
        nodeLeft.insertRight(5);
        nodeLeft.insertLeft(8);            
        nodeRight.insertLeft(4);
        nodeRight.insertRight(5).insertRight(8).insertRight(4);
        nodeRight.insertLeft(8); 
        
        System.out.println("tree.height>>>BinaryTree.LEFT>>>"+tree.height(tree.root, BinaryTree.LEFT));
        System.out.println("tree.height>>>BinaryTree.RIGHT>>>"+tree.height(tree.root, BinaryTree.RIGHT));
        
        System.out.println("tree.isSuperbalanced>>>"+tree.isSuperbalanced(tree.root));


    }
	
	public static class BinaryTree{
		BinaryTreeNode root;
		
		public static final String LEFT = "LEFT";
		public static final String RIGHT = "RIGHT";
		
		public int height(BinaryTreeNode node, String direction){
			
			if(node == null){
				return 0;
			}
			
//			System.out.println(node.value);
			if(direction == LEFT){
				node = node.left;
			}else if(direction == RIGHT){
				node = node.right;
			}
			
			return (1 + height(node, direction));
		}
		

		public boolean isSuperbalanced(BinaryTreeNode node) {
			if(node == null){
				return true;
			}
			int leftHeight = height(node, BinaryTree.LEFT);
			int rightHeight = height(node, BinaryTree.RIGHT);
			
			if(Math.abs(leftHeight-rightHeight) <=1 
					&& isSuperbalanced(node.left) 
					&& isSuperbalanced(node.right)){
				return true;
			}
			
			return false;
		}
	}

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
			left = right = null;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}	

	}

}
