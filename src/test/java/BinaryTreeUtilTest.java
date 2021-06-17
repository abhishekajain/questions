import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeUtilTest {
    @Test
    public void fullTreeTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(5);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        root.insertLeft(5);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(9);
        b.insertLeft(8).insertLeft(7);
        b.insertRight(5);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTwoTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(2);
        a.insertLeft(3);
        a.insertRight(7).insertRight(8);
        root.insertRight(4).insertRight(5).insertRight(6).insertRight(9);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void threeLeavesAtDifferentLevelsTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(2);
        final BinaryTreeUtil.BinaryTreeNode b = a.insertLeft(3);
        a.insertRight(4);
        b.insertLeft(5);
        b.insertRight(6);
        root.insertRight(7).insertRight(8).insertRight(9).insertRight(10);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void treeIsLinkedListTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        root.insertRight(2).insertRight(3).insertRight(4);
        final boolean result = BinaryTreeUtil.isBalanced(root);
        assertTrue(result);
    }


    @Test
    public void validFullTreeTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final boolean result = BinaryTreeUtil.isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void bothSubtreesValidTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        final boolean result = BinaryTreeUtil.isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void descendingLinkedListTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        final boolean result = BinaryTreeUtil.isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void outOfOrderLinkedListTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        root.insertRight(70).insertRight(60).insertRight(80);
        final boolean result = BinaryTreeUtil.isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void oneNodeTreeTest() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final boolean result = BinaryTreeUtil.isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void validFullTreeTest1() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(10);
        a.insertRight(40);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60);
        b.insertRight(80);
        final boolean result = BinaryTreeUtil.checkBST(root);
        assertTrue(result);
    }

    @Test
    public void bothSubtreesValidTest1() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        final boolean result = BinaryTreeUtil.checkBST(root);
        assertFalse(result);
    }

    @Test
    public void descendingLinkedListTest1() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        final boolean result = BinaryTreeUtil.checkBST(root);
        assertTrue(result);
    }

    @Test
    public void outOfOrderLinkedListTest1() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        root.insertRight(70).insertRight(60).insertRight(80);
        final boolean result = BinaryTreeUtil.checkBST(root);
        assertFalse(result);
    }

    @Test
    public void oneNodeTreeTest1() {
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(50);
        final boolean result = BinaryTreeUtil.checkBST(root);
        assertTrue(result);
    }

    @Test
    public void testTopView(){
        final BinaryTreeUtil.BinaryTreeNode root = new BinaryTreeUtil.BinaryTreeNode(1);
        final BinaryTreeUtil.BinaryTreeNode a = root.insertLeft(2);
        a.insertLeft(4);
        a.insertRight(5);
        final BinaryTreeUtil.BinaryTreeNode b = root.insertRight(3);
        b.insertLeft(6);
        b.insertRight(7);
        BinaryTreeUtil.topView(root);
        assertTrue(true);

    }

}
