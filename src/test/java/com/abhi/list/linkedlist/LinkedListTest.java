package com.abhi.list.linkedlist;


import org.junit.Test;

public class LinkedListTest {
	
    @Test
    public void testAddToFront() {
        LinkedList list = new LinkedList();
        list.addToFront(5);
        list.addToFront(15);
        list.addToFront(8);
        list.addToFront(10);
        list.addToFront(11);

        list.print();
        System.out.println();
        System.out.println(list.removeFromFront().getValue());
        list.print();
        System.out.println();
        System.out.println(list.removeFromEnd().getValue());
        list.print();
        assert true;
    }

}
