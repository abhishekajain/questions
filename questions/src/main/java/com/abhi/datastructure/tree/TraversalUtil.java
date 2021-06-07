package com.abhi.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class TraversalUtil {
	
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(root == null) {
    		return results;
    	}    
    	List<VerticalXValues> list = new ArrayList<VerticalXValues>();
    	traverse(root, list, 0, 0);
    	Collections.sort(list);
    	System.out.println(list);
    	
    	int x = Integer.MAX_VALUE;
    	List<Integer> resultX = null;
    	for(VerticalXValues vx: list) {
    		if(x != vx.x) {    			
    			resultX  = new ArrayList<Integer>();
    			results.add(resultX);
    			x = vx.x;
    		}
    		resultX.add(vx.val);
    	}
    	return results;
    }
    
    private static void traverse(TreeNode node, List<VerticalXValues> list, int x, int y) {
    	if(node.left != null) {
    		traverse(node.left, list, x-1, y-1);
    	}
    	VerticalXValues vX = new VerticalXValues();
    	vX.val = node.val;
    	vX.x = x;
    	vX.y = y;
    	list.add(vX);
    	if(node.right != null) {
    		traverse(node.right, list, x+1, y-1);
    	}
    }
    
    static class VerticalXValues implements Comparable<VerticalXValues>{
    	int val;
    	int x;
    	int y;
    	
	

		@Override
		public String toString() {
			return "VerticalXValues [val=" + val + ", x=" + x + ", y=" + y + "]";
		}



		@Override
		public int compareTo(VerticalXValues o) {
			if(this.x == o.x) {
				if(this.y == o.y)
					return this.val - o.val;
				else
					return o.y - this.y;
			}
			return this.x - o.x;
		}  	
    	
    }
    
    @Test
    public void testVerticalTraversal() {
    	TreeNode root = new TreeNode(1);
    	TreeNode rootLeft = new TreeNode(2);
    	TreeNode rootRight = new TreeNode(3);
    	root.left = rootLeft;
    	root.right = rootRight;
    	
    	TreeNode rootLeftLeft = new TreeNode(4);
    	TreeNode rootLeftRight = new TreeNode(5);
    	rootLeft.left = rootLeftLeft;
    	rootLeft.right = rootLeftRight;

    	TreeNode rootRightLeft = new TreeNode(6);
    	TreeNode rootRightRight = new TreeNode(7);
    	rootRight.left = rootRightLeft;
    	rootRight.right = rootRightRight;
    	
    	System.out.println(inorderTraversalLoop(root));
    	
    	System.out.println(verticalTraversal(root));
    	
    }
    
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null)
        	traverse(root, result);
        return result;
    }
    
    public static List<Integer> inorderTraversalLoop(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        
        while(current != null || !stack.isEmpty()) {
        	while(current!= null){
        		stack.push(current);        	
        		current = current.left;
        	}
        	current = stack.pop();
        	result.add(current.val);
        	current = current.right;
        }

        return result;
    }
    
    private static void traverse(TreeNode node, List<Integer> list) {
    	if(node.left != null) {
    		traverse(node.left, list);
    	}
    	list.add(node.val);
    	if(node.right != null) {
    		traverse(node.right, list);
    	}
    }
}
