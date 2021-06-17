package org.abhishek.learn.tree.binary.search;

public class Tree {
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int min(){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        return root.min();
    }

    public int max(){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return root.max();
    }

    public Node get(int value){
        if(root == null){
            return null;
        }
        return root.get(value);
    }

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }else {
            root.insert(value);
        }
    }
}
