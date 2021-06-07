package com.abhi.tree.binarysearch;

public class BSTHeightFromLeafNode {

    public static int findHeightFromBottom(TreeNode s) {
        return findMaxHeight(s);
    }

    private static int findMaxHeight(TreeNode s) {
        int leftHeight =0;
        int rightHeight =0;
        if(isChildNode(s)) {
            return 0;
        }
        if(s.getLeft() != null) {
            leftHeight =  findMaxHeight(s.getLeft());
        }
        if(s.getRight() !=null) {
            rightHeight = findMaxHeight(s.getRight());
        }
        return Math.max(leftHeight, rightHeight) +1;
    }



    private static boolean isChildNode(TreeNode s) {
        return s.getLeft() == null && s.getRight() == null;
    }


}
