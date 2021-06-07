package com.abhi.tree;

public class BinarySearchTree {
//    10 35 12 13 56 32 11 76
    private Node root = null;

//    start with 10
    public BinarySearchTree(int rootValue){
        this.root = new Node(rootValue);
    }

//  depth-first: Inorder, Preorder, Postorder,
//  breadth-first: level order traversal
//  Depth-first search is easily implemented via a stack, including recursively (via the call stack),
//  Breadth-first search is easily implemented via a queue, including corecursively.
    public void traverse(){

    }

    public void add(int value){
        Node currentNode = this.root;
        if(value < this.root.value){
//            look left
        }else{
//            look right
        }
    }

    public Node find(int value){
        return null;
    }

    public Node delete(int value){
        return null;
    }

    public Node min(){
        return null;
    }

    public Node max(){
        return null;
    }

//    AVL and Red Black Tree for Tree balancing
}
