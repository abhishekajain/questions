package com.abhi.datastructure;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LinkedList {
	
	static class LinkedListNode{
		public int value;
		public LinkedListNode next;
		
		public LinkedListNode(int value){
			this.value = value;
			this.next = null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.value);
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LinkedListNode other = (LinkedListNode) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value != other.value)
				return false;
			return true;
		}		
		
	}
	
	public LinkedListNode head;//firstNode
	
	public static boolean containsCycle(LinkedListNode head){
		Set<LinkedListNode> set = new HashSet<LinkedListNode>();
		
		while(head != null){
			set.add(head);
			head = head.next;
			if(set.contains(head)){
				return true;
			}
		}
		return false;
	}
	
	public static int size(LinkedListNode head){
		int size = 0;
		while(head != null && size != Integer.MAX_VALUE){
			size++;
			head = head.next;
		}
		return size;
	}
	
	public static void print(LinkedListNode head){
		if(head == null){
			System.out.println("end");
			return;
		}
		if(head != null){
			System.out.print(head.value);
			System.out.print("-->");
			print(head.next);
		}
	}
	
	@Test
	public void testContainsCycle(){
		LinkedListNode head = new LinkedListNode(0);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(2);
		print(head);
		Assert.assertEquals(3, size(head));
		Assert.assertFalse(containsCycle(head));
		head.next.next.next = head.next;
//		print(head);

		Assert.assertTrue(containsCycle(head));
		Assert.assertEquals(Integer.MAX_VALUE, size(head));
	}
	
//	Reverse a linked list from position m to n. Do it in-place and in one-pass.
//	For example:
//	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//	return 1->4->3->2->5->NULL.
	public static LinkedListNode reverseLinkList(LinkedListNode head){
		if(head == null){
			return head;
		}
		LinkedListNode previous = null;
		LinkedListNode current = head;
		LinkedListNode next = null;
		while(current != null){
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;
	}
	
	// A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    static void reverseUtil(LinkedListNode curr, LinkedListNode prev) {		
    	if(curr.next == null){
        	curr.next = prev;
        	return;
    	}
    	
    	LinkedListNode next = curr.next;
    	curr.next = prev;
    	reverseUtil(next, curr);
		
    }
    
//    you are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

//    		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    		Output: 7 -> 0 -> 8

//    		    342 + 465 = 807
//    		Make sure there are no trailing zeros in the output list
//    		So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
    
	public LinkedListNode addTwoNumbers(LinkedListNode a, LinkedListNode b) {
		LinkedListNode current1 = a; 
		LinkedListNode current2 = b; 
		LinkedListNode next1 = null;
		LinkedListNode next2 = null;

    	int headVal = current1.value+current2.value;
    	LinkedListNode current = new LinkedListNode(headVal%10);
    	LinkedListNode next = null;
    	LinkedListNode head = current;
    	int nextSum = headVal/10;
    	while(current1.next != null || current2.next != null){
    		next1 = current1.next;
    		int value1 = 0;
    		if(next1 != null){
        		current1 = next1;
        		value1 = next1.value;
    		}
    		next2 = current2.next;
    		int value2 = 0;

    		if(next2 != null){
        		current2 = next2;
        		value2 = next2.value;

    		}
    		
    		int value = value1+value2+nextSum;
    		next = new LinkedListNode(value%10);
    		nextSum = value/10;
    		current.next = next;
    		current = next;
    	}
        
        if(nextSum != 0){
            next = new LinkedListNode(nextSum);
    		current.next = next;
        }
    	return head;		
	    
	}
    
    @Test
    public void testAdd(){
    	LinkedList list1 = new LinkedList();
    	LinkedList list2 = new LinkedList();
    	
		LinkedListNode head = new LinkedListNode(2);
		head.next = new LinkedListNode(4);
		head.next.next = new LinkedListNode(3);
		list1.head = head;

		LinkedListNode head2 = new LinkedListNode(5);
		head2.next = new LinkedListNode(6);
//		head2.next.next = new LinkedListNode(4);
		list2.head = head2;
		print(head);
		print(head2);
		print(addTwoNumbers(head, head2));
    }
 
    // prints content of double linked list
    static void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.value + "->>");
            node = node.next;
        }
    }
    
	public static LinkedListNode reverseLinkList(LinkedListNode head, int m){

		return head;
	}
	
	@Test
	public void testReverseLinkList(){
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		print(head);
		head = reverseLinkList(head);
		print(head);
	}

}
