package com.abhi.example;

/**
 * A binary search tree is a binary tree in which, for each node:
 * 
 * The node's value is greater than all values in the left subtree. The node's
 * value is less than all values in the right subtree. BSTs are useful for quick
 * lookups. If the tree is balanced, we can search for a given value in the tree
 * in O(\lg{n})O(lgn) time.
 * 
 * @author abhishek.ajain
 *
 */
public class BinarySearchTree {
	
	public static void main(String[] args){
		BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.left.left.left = new BinaryTreeNode(8);
        
        System.out.println("tree.isBinarySearchTree>>>"+tree.isBinarySearchTree(tree.root));
        
		BinaryTree tree1 = new BinaryTree();
		tree1.root = new BinaryTreeNode(50);
		tree1.root.left = new BinaryTreeNode(30);
		tree1.root.right = new BinaryTreeNode(80);
		tree1.root.left.left = new BinaryTreeNode(20);
		tree1.root.left.right = new BinaryTreeNode(60);
		tree1.root.right.left = new BinaryTreeNode(70);
		tree1.root.right.right = new BinaryTreeNode(90);
		tree1.display(tree1.root, "ROOT");
        System.out.println("tree.isBinarySearchTree>>>"+tree1.isBinarySearchTree(tree1.root));
	}
	
	
	public static class BinaryTree{
		BinaryTreeNode root;
		
		public boolean isBinarySearchTree(BinaryTreeNode node){
			if(node == null){
				return true;
			}
			if(( (node.left == null || node.left.value<=node.value) && (node.right == null || node.right.value>=node.value) )
					&& isBinarySearchTree(node.left) 
					&& isBinarySearchTree(node.right)){
				return true;
			}
			return false;
		}
		
		public void display(BinaryTreeNode root, String dirction){
			if(root!=null){
				display(root.left, "LEFT<<<");
				System.out.print(" "+dirction+" " + root.value);
				display(root.right, ">>>RIGHT");
			}
		}

	}
	
	public static class BinaryTreeNode {

	    public int value;
	    public BinaryTreeNode left, right;

	    public BinaryTreeNode(int value) {
	        this.value = value;
			left = right = null;
	    }
	}

}
