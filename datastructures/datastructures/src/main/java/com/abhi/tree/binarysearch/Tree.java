package com.abhi.tree.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public void add(int value){
        if(this.root == null){
            this.root = new TreeNode(value);
        }else{
            this.root.add(value);
        }
    }
    public List<Integer> depthFirstInOrderTraversal(){
        if(root == null){
            return null;
        }else{
            List<Integer> elements = new ArrayList<Integer>();
            root.depthFirstInOrderTraversal(elements);
            return elements;
        }
    }
}
