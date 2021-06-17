package com.abhi;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class BinaryTreeUtil {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        // determine if the tree is a valid binary search tree

        return isVlidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        return isValidBST(root);
    }

    static void bfs(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            System.out.print(current.value+"->");
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }
    }

    static void dfs(BinaryTreeNode node){
        System.out.print(node.value+"->");
        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
        }
    }

    static void inorder(BinaryTreeNode node){
        if(node.left != null){
            inorder(node.left);
        }
        System.out.print(node.value+"->");
        if(node.right != null){
            inorder(node.right);
        }
    }

    static void reverseinorder(BinaryTreeNode node){
        if(node.right != null){
            reverseinorder(node.right);
        }
        System.out.print(node.value+"->");
        if(node.left != null){
            reverseinorder(node.left);
        }
    }

    static void reverseinorderlist(BinaryTreeNode node, List<Integer> list){
        if(node.right != null){
            reverseinorderlist(node.right, list);
        }
        System.out.print(node.value+"->");
        list.add(node.value);
        if(node.left != null){
            reverseinorderlist(node.left, list);
        }
    }


    static void postorder(BinaryTreeNode node){
        if(node.left != null){
            postorder(node.left);
        }
        if(node.right != null){
            postorder(node.right);
        }
        System.out.print(node.value+"->");
    }


    static int findMax(BinaryTreeNode node, int max){
        if(max<node.value){
            max = node.value;
        }
        if(node.left != null){
            max = findMax(node.left, max);
        }
        if(node.right != null){
            max = findMax(node.right, max);
        }

        return max;
    }

    static int findMin(BinaryTreeNode node, int min){
        if(min>node.value){
            min = node.value;
        }
        if(node.left != null){
            min = findMin(node.left, min);
        }
        if(node.right != null){
            min = findMin(node.right, min);
        }

        return min;
    }

    static boolean isValidBST(BinaryTreeNode node){
        int val = node.value;
        if(node.left != null) {
            int leftMax = findMax(node.left, Integer.MIN_VALUE);
            if(val < leftMax){
                return false;
            }else{
                return isValidBST(node.left);
            }
        }
        if(node.right != null) {
            int rightMin = findMin(node.right, Integer.MAX_VALUE);
            if(val > rightMin){
                return false;
            }else{
                return isValidBST(node.right);
            }
        }
        return true;
    }

    static boolean isVlidBinarySearchTree(BinaryTreeNode node, int lower, int upper){
        if(node == null){
            return true;
        }
        int val = node.value;
        if(val<=lower || val>=upper){
            return false;
        }
        return isVlidBinarySearchTree(node.left, lower, node.value) && isVlidBinarySearchTree(node.right, node.value, upper);
    }


    public static BinaryTreeNode searchBST(BinaryTreeNode root, int searchItem){
        BinaryTreeNode current = root;
        while(current != null){
            if(current.value == searchItem){
                return current;
            }else if(searchItem<current.value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return null;
    }

    public static BinaryTreeNode searchBSTR(BinaryTreeNode node, int searchItem){
        if(node == null || node.value == searchItem){
            return node;
        }else if(searchItem<node.value){
            return searchBSTR(node.left, searchItem);
        }else{
            return searchBSTR(node.right, searchItem);
        }
    }

    public static BinaryTreeNode insertBST(BinaryTreeNode root, int value){
        if(root == null){
            root = new BinaryTreeNode(value);
            return root;
        }
        BinaryTreeNode current = root;
        while(current != null) {
//        if value greater than node value go right
            if (value > current.value) {
                if(current.right == null){
                    current.right = new BinaryTreeNode(value);
                    break;
                }
                current = current.right;
            }else{
                if(current.left == null){
                    current.left = new BinaryTreeNode(value);
                    break;
                }
                current = current.left;
            }
        }
        return root;
    }

    public static BinaryTreeNode insertBSTRec(BinaryTreeNode root, int value){
        if(root == null){
            root = new BinaryTreeNode(value);
            return root;
        }

        if(value>root.value){
            root.right = insertBSTRec(root.right, value);
        }else{
            root.left = insertBSTRec(root.left, value);
        }

        return root;
    }

    public static int findLargestBST(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        BinaryTreeNode previous = null;
        while (current.right != null){
            previous = current;
            current = current.right;
        }
        if(previous == null){
            if(current.left == null){
                throw new RuntimeException();
            }else{
                if(current.left.right != null){
                    return findLargestBST(current.left);
                }
                return current.left.value;
            }
        }
        return previous.value;
    }

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        List<Integer> list = new ArrayList<>();
        reverseinorderlist(rootNode, list);
        if(list.size()>1){
            return list.get(1);
        }
        throw new RuntimeException();
    }


    @Test
    public void testInsert(){


        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        BinaryTreeNode root = insertBST(null, 50);
        root = insertBST(root, 30);
        root = insertBST(root, 20);
        root = insertBST(root, 40);
        root = insertBST(root, 70);
        root = insertBST(root, 60);
        root = insertBST(root, 80);

        reverseinorder(root);
        // print inorder traversal of the BST

        assert true;
    }


    @Test
    public void testInsertBSTRec(){


        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */

        BinaryTreeNode root = insertBSTRec(null, 50);
        root = insertBSTRec(root, 30);
        root = insertBSTRec(root, 20);
        root = insertBSTRec(root, 40);
        root = insertBSTRec(root, 70);
        root = insertBSTRec(root, 60);
        root = insertBSTRec(root, 80);
        root = insertBSTRec(root, 10);

        inorder(root);
        List<Integer> list = new ArrayList<>();
        reverseinorderlist(root, list);
        System.out.println(list);
        // print inorder traversal of the BST

        assert true;
    }














    // tests

    @Test
    public void findSecondLargestTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftChildTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70).insertLeft(60);
        final int actual = findSecondLargest(root);
        final int expected = 60;
        assertEquals(expected, actual);
    }

    @Test
    public void largestHasLeftSubtreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70).insertLeft(60);
        b.insertLeft(55).insertRight(58);
        b.insertRight(65);
        final int actual = findSecondLargest(root);
        final int expected = 65;
        assertEquals(expected, actual);
    }

    @Test
    public void secondLargestIsRootNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        root.insertRight(70);
        final int actual = findSecondLargest(root);
        final int expected = 50;
        assertEquals(expected, actual);
    }

    @Test
    public void twoNodesRootIsLargestTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(30);
        final int actual = findSecondLargest(root);
        final int expected = 30;
        assertEquals(expected, actual);
    }

    @Test
    public void descendingLinkedListSecondLargestTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20);
        final int actual = findSecondLargest(root);
        final int expected = 40;
        assertEquals(expected, actual);
    }

    @Test
    public void ascendingLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertRight(60).insertRight(70).insertRight(80);
        final int actual = findSecondLargest(root);
        final int expected = 70;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithTreeThatHasOneNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        findSecondLargest(root);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyTreeTest() {
        findSecondLargest(null);
    }



    @Test
    public void travserseTest() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left = root.insertLeft(2);
        BinaryTreeNode right = root.insertRight(3);
        left.insertLeft(4);
        left.insertRight(5);
        right.insertLeft(6);
        right.insertRight(7);
        System.out.println("DFS");
        dfs(root);
        System.out.println("inorder");
        inorder(root);
        System.out.println("postorder");
        postorder(root);
        System.out.println("");
        System.out.println("findMax");
        System.out.println(findMax(root, Integer.MIN_VALUE));
        System.out.println("");
        System.out.println("findMin");
        System.out.println(findMin(root, Integer.MAX_VALUE));
        System.out.println("");
        System.out.println("BFS");
        bfs(root);
        assert true;
    }



    // tests

    @Test
    public void validFullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void bothSubtreesValidTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final BinaryTreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        final boolean result = isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void descendingLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void outOfOrderLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertRight(70).insertRight(60).insertRight(80);
        final boolean result = isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void oneNodeTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BinaryTreeUtil.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}