package com.abhi.tree.binarysearch;

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

    public void add(int data){
        if(data == this.data){
            return;
        }
        if(data>this.data){
            if(this.right == null){
                this.right = new TreeNode(data);
            }else{
                this.right.add(data);
            }
        }else{
            if(this.left == null){
                this.left = new TreeNode(data);
            }else{
                this.left.add(data);
            }
        }
    }

    /**
     * Depth First Traversals:
     * (a) Inorder (Left, Root, Right) :
     * (b) Preorder (Root, Left, Right) :
     * (c) Postorder (Left, Right, Root) :
     *
     * Breadth First or Level Order Traversal :
     */
    public void depthFirstInOrderRecursive(){
        if(this.left != null){
            this.left.depthFirstInOrderRecursive();
        }
        System.out.print(this.data+" ");
        if(this.right != null){
            this.right.depthFirstInOrderRecursive();
        }
    }
//  root --> left --> right
    public void depthFirstPreOrderRecursive(){
        System.out.print(this.data+" ");
        if(this.left != null){
            this.left.depthFirstPreOrderRecursive();
        }
        if(this.right != null){
            this.right.depthFirstPreOrderRecursive();
        }
    }

    //  left --> right --> root
    public void depthFirstPostOrderRecursive(){
        if(this.left != null){
            this.left.depthFirstPostOrderRecursive();
        }
        if(this.right != null){
            this.right.depthFirstPostOrderRecursive();
        }
        System.out.print(this.data+" ");
    }
}
