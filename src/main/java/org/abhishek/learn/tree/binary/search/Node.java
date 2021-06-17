package org.abhishek.learn.tree.binary.search;

public class Node {
    private Node rightChild = null;
    private Node leftChild = null;
    private int data;

    public Node(int data){
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void insert(int value){
        if (data == value){
            return;
        }

        if(value < data){
            if(leftChild == null){
                leftChild = new Node(value);
            }else{
                leftChild.insert(value);
            }
        }else{
            if(rightChild == null){
                rightChild = new Node(value);
            }else{
                rightChild.insert(value);
            }
        }
    }

    public Node get(int value){
        if (data == value){
            return this;
        }
        if(value < data){
            if(leftChild != null){
                leftChild.get(value);
            }
        }else{
            if(rightChild != null){
                rightChild.get(value);
            }
        }

        return null;
    }

    public int min(){
        if(leftChild == null){
            return data;
        }

         return leftChild.min();
    }

    public int max(){
        if(rightChild == null){
            return data;
        }

        return rightChild.max();
    }

}
