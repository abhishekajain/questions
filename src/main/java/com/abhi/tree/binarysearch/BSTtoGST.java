package com.abhi.tree.binarysearch;

import java.util.Stack;

/**
 * Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to
 * the sum of the values of the original tree that are greater than or equal to node.val.
 */
public class BSTtoGST {

    public TreeNode bstToGst(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> elements = new Stack<TreeNode>();
        depthFirstInOrderTraversalStack(root, elements);
        sumOfPre(elements);
        return root;
    }

    private void depthFirstInOrderTraversalStack(TreeNode  node, Stack<TreeNode> elements){
        if(node.getLeft() != null){
            depthFirstInOrderTraversalStack(node.getLeft(), elements);
        }
        elements.push(node);
        if(node.getRight() != null){
            depthFirstInOrderTraversalStack(node.getRight(), elements);
        }
    }

    private void sumOfPre(Stack<TreeNode> elements){
        int sum = 0;
        while(!elements.isEmpty()){
            TreeNode currentElement = elements.pop();
            sum += currentElement.getData();
            currentElement.setData(sum);
        }
    }

    public TreeNode bstToGst_Modified(TreeNode root) {
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            int size = 0;
            TreeNode currentElement = root;
            while (!stack.isEmpty()){
                if(currentElement.getRight() != null){
                    stack.push(currentElement.getRight());
                }
                currentElement = stack.pop();
                size = size + currentElement.getData();
                currentElement.setData(size);
                if(currentElement.getLeft() != null){
                    stack.push(currentElement.getLeft());
                }
            }
        }
        return root;
    }
}
