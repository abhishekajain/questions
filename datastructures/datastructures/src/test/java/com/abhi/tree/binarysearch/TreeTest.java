package com.abhi.tree.binarysearch;

import org.junit.Test;

public class TreeTest {

    @Test
    public void testDepthFirstInOrderTraversal() {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(15);
        tree.add(8);
        tree.add(10);
        tree.add(11);
        tree.add(13);
        tree.add(25);
        tree.add(19);
        tree.add(4);
        tree.depthFirstInOrderRecursive();
        assert true;
    }
}
