package com.abhi.tree.binarysearch;

import java.util.List;

public class TreeNode {

    private int  data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void add(int value){
        if(value == this.data){
            return;
        }else if(value < this.data){
            if(this.left == null){
                this.left = new TreeNode(value);
                return;
            }else{
                this.left.add(value);
            }
        }else{
            if(this.right == null){
                this.right = new TreeNode(value);
                return;
            }else{
                this.right.add(value);
            }
        }
    }

    public void depthFirstInOrderTraversal(List<Integer> elements){
        if(this.left != null){
            this.left.depthFirstInOrderTraversal(elements);
        }
        elements.add(this.data);
        if(this.right != null){
            this.right.depthFirstInOrderTraversal(elements);
        }
    }
}
