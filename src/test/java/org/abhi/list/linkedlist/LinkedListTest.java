package org.abhi.list.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testGetNode(){
        LinkedListUtil.SinglyLinkedListNode head = new LinkedListUtil.SinglyLinkedListNode(5);
        head.next = new LinkedListUtil.SinglyLinkedListNode(4);
        head.next.next = new LinkedListUtil.SinglyLinkedListNode(3);
        head.next.next.next = new LinkedListUtil.SinglyLinkedListNode(2);
        head.next.next.next.next = new LinkedListUtil.SinglyLinkedListNode(1);
        head.next.next.next.next.next = new LinkedListUtil.SinglyLinkedListNode(0);

        Assert.assertEquals(2, LinkedListUtil.getNode(head,2));
    }
}
