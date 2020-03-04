package com.abhi.tree.binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private TreeNode root;

    public void add(int data) {
        if (this.root == null) {
            this.root = new TreeNode(data);
        } else {
            this.root.add(data);
        }
    }

    public void depthFirstInOrderRecursive() {
        if (root != null) {
            root.depthFirstInOrderRecursive();
        }
    }

    public void depthFirstPreOrderRecursive() {
        if (root != null) {
            root.depthFirstPreOrderRecursive();
        }
    }

    public void depthFirstPostOrderRecursive() {
        if (root != null) {
            root.depthFirstPostOrderRecursive();
        }
    }

//  print level first
    public void printBreadthFirstIterative() {
        if (root == null) {
            return;
        }
//      First come first out
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentElement = queue.poll();
            System.out.print(currentElement.getData() + " ");
            if (currentElement.getLeft() != null)
                queue.add(currentElement.getLeft());
            if (currentElement.getRight() != null)
                queue.add(currentElement.getRight());
        }
    }

//  Given a binary tree, print its nodes according to the "bottom-up" postorder traversal. left -- right -- root
    public void printPostorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostorder(node.getLeft());
        printPostorder(node.getRight());
        System.out.print(node.getData() + " ");
    }

//  Given a binary tree, print its nodes in inorder left -- root - right
    public void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInorder(node.getRight());
    }

//  Given a binary tree, print its nodes in preorder root -- left -- right
    public void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        printPreorder(node.getLeft());
        printPreorder(node.getRight());
    }

    public TreeNode getMin(){
        if(root == null){
            return null;
        }else{
            TreeNode currentElement = root;
            while(currentElement.getLeft() != null){
                currentElement = currentElement.getLeft();
            }
            System.out.println(currentElement.getData());
            return currentElement;
        }
    }
    public TreeNode getMax(){
        if(root == null){
            return null;
        }else{
            TreeNode currentElement = root;
            while(currentElement.getRight() != null){
                currentElement = currentElement.getRight();
            }
            System.out.println(currentElement.getData());
            return currentElement;
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(15);
        tree.add(8);
        tree.add(10);
        tree.add(11);
        tree.add(13);
        tree.add(25);
        tree.add(19);
        tree.add(4);
        System.out.println("depthFirstInOrderRecursive:");
        tree.depthFirstInOrderRecursive();
        System.out.println("\ndepthFirstPreOrderRecursive:");
        tree.depthFirstPreOrderRecursive();
        System.out.println("\ndepthFirstPostOrderRecursive:");
        tree.depthFirstPostOrderRecursive();
        System.out.println("\nprintBreadthFirstIterative:");
        tree.printBreadthFirstIterative();
        System.out.println("\ngetMax:");
        tree.getMax();
        System.out.println("\ngetMin:");
        tree.getMin();

        Tree second_tree = new Tree();
        second_tree.add(25);
        second_tree.add(15);
        second_tree.add(50);
        second_tree.add(10);
        second_tree.add(22);
        second_tree.add(35);
        second_tree.add(70);
        second_tree.add(4);
        second_tree.add(12);
        second_tree.add(18);
        second_tree.add(24);
        second_tree.add(31);
        second_tree.add(44);
        second_tree.add(66);
        second_tree.add(90);
        System.out.println("\ndepthFirstInOrderRecursive:");
        second_tree.depthFirstInOrderRecursive();
        System.out.println("\ndepthFirstPreOrderRecursive:");
        second_tree.depthFirstPreOrderRecursive();
        System.out.println("\ndepthFirstPostOrderRecursive:");
        second_tree.depthFirstPostOrderRecursive();
        System.out.println("\nprintInorder:");
        second_tree.printInorder(second_tree.root);
        System.out.println("\nprintPreorder:");
        second_tree.printPreorder(second_tree.root);
        System.out.println("\nprintPostorder:");
        second_tree.printPostorder(second_tree.root);
        System.out.println("\nprintBreadthFirstIterative:");
        second_tree.printBreadthFirstIterative();
        System.out.println("\ngetMax:");
        second_tree.getMax();
        System.out.println("\ngetMin:");
        second_tree.getMin();
    }
}
