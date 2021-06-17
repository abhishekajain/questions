package org.abhi.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testAvgEachLevel(){
        BinaryTree.Node node = new BinaryTree.Node(4);
        node.left = new BinaryTree.Node(7);
        node.right = new BinaryTree.Node(9);

        node.left.left = new BinaryTree.Node(10);
        node.left.right = new BinaryTree.Node(2);

        node.right.right = new BinaryTree.Node(6);

        node.left.right.right = new BinaryTree.Node(6);

        node.left.right.right.left = new BinaryTree.Node(2);

        int[] result = BinaryTree.avgEachLevel(node);
        int[] expected = {4, 8, 6, 6, 2};
        Assert.assertArrayEquals(expected, result);

        Integer[] result2 = BinaryTree.avgEachLevelD(node);
        Integer[] expected2 = {4, 8, 6, 6, 2};
        Assert.assertArrayEquals(expected2, result2);

    }
}
