package com.abhi.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LinkedList {

	public LinkedListNode head;// firstNode

	public static boolean containsCycle(LinkedListNode head) {
		Set<LinkedListNode> set = new HashSet<LinkedListNode>();

		while (head != null) {
			set.add(head);
			head = head.next;
			if (set.contains(head)) {
				return true;
			}
		}
		return false;
	}

	public static int size(LinkedListNode head) {
		int size = 0;
		while (head != null && size != Integer.MAX_VALUE) {
			size++;
			head = head.next;
		}
		return size;
	}

	public static void print(LinkedListNode head) {
		if (head == null) {
			System.out.println("end");
			return;
		}
		if (head != null) {
			System.out.print(head.value);
			System.out.print("-->");
			print(head.next);
		}
	}

	@Test
	public void testContainsCycle() {
		LinkedListNode head = new LinkedListNode(0);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(2);
		print(head);
		Assert.assertEquals(3, size(head));
		Assert.assertFalse(containsCycle(head));
		head.next.next.next = head.next;
		// print(head);

		Assert.assertTrue(containsCycle(head));
		Assert.assertEquals(Integer.MAX_VALUE, size(head));
	}

	// Reverse a linked list from position m to n. Do it in-place and in
	// one-pass.
	// For example:
	// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	// return 1->4->3->2->5->NULL.
	public static LinkedListNode reverseLinkList(LinkedListNode head) {
		if (head == null) {
			return head;
		}
		LinkedListNode previous = null;
		LinkedListNode current = head;
		LinkedListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
		return head;
	}

	// Reverse a linked list from position m to n. Do it in-place and in
	// one-pass.
	// For example:
	// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	// return 1->4->3->2->5->NULL.
	public static LinkedListNode reverseLinkList(LinkedListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		if (n <= m) {
			return head;// nothing to do//what will happen when m =1
		}
		LinkedListNode previous = null;
		LinkedListNode current = head;
		LinkedListNode next = null;
		LinkedListNode headToTrack = null;
		int index = 1;
		while (current != null && index < m) {
			index++;
			previous = current;
			current = current.next;
		}
		if (m == 1) {
			head = reverseLinkList(current, n);
		} else {
			previous.next = reverseLinkList(current, n);
		}
		// head = previous;
		return head;
	}

	public static LinkedListNode reverseLinkList(LinkedListNode head, int n) {
		if (head == null) {
			return head;
		}
		LinkedListNode previous = null;
		LinkedListNode current = head;
		LinkedListNode next = null;
		int index = 1;

		while (current != null && index < n) {
			index++;
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head.next = current;
		head = previous;
		return head;
	}

	// A simple and tail recursive function to reverse
	// a linked list. prev is passed as NULL initially.
	static void reverseUtil(LinkedListNode curr, LinkedListNode prev) {
		if (curr.next == null) {
			curr.next = prev;
			return;
		}

		LinkedListNode next = curr.next;
		curr.next = prev;
		reverseUtil(next, curr);

	}

	// you are given two linked lists representing two non-negative numbers. The
	// digits are stored in reverse order and each of their nodes contain a
	// single digit. Add the two numbers and return it as a linked list.

	// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	// Output: 7 -> 0 -> 8

	// 342 + 465 = 807
	// Make sure there are no trailing zeros in the output list
	// So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is
	// still 807.

	public LinkedListNode addTwoNumbers(LinkedListNode a, LinkedListNode b) {
		LinkedListNode current1 = a;
		LinkedListNode current2 = b;
		LinkedListNode next1 = null;
		LinkedListNode next2 = null;

		int headVal = current1.value + current2.value;
		LinkedListNode current = new LinkedListNode(headVal % 10);
		LinkedListNode next = null;
		LinkedListNode head = current;
		int nextSum = headVal / 10;
		while (current1.next != null || current2.next != null) {
			next1 = current1.next;
			int value1 = 0;
			if (next1 != null) {
				current1 = next1;
				value1 = next1.value;
			}
			next2 = current2.next;
			int value2 = 0;

			if (next2 != null) {
				current2 = next2;
				value2 = next2.value;

			}

			int value = value1 + value2 + nextSum;
			next = new LinkedListNode(value % 10);
			nextSum = value / 10;
			current.next = next;
			current = next;
		}

		if (nextSum != 0) {
			next = new LinkedListNode(nextSum);
			current.next = next;
		}
		return head;

	}

	@Test
	public void testAdd() {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();

		LinkedListNode head = new LinkedListNode(2);
		head.next = new LinkedListNode(4);
		head.next.next = new LinkedListNode(3);
		list1.head = head;

		LinkedListNode head2 = new LinkedListNode(5);
		head2.next = new LinkedListNode(6);
		// head2.next.next = new LinkedListNode(4);
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

	@Test
	public void testReverseLinkListWithBound() {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		// head.next.next.next = new LinkedListNode(4);
		// head.next.next.next.next = new LinkedListNode(5);
		System.out.println("testReverseLinkListWithBound-->");
		print(head);
		head = reverseLinkList(head, 1, 2);
		print(head);
		System.out.println("testReverseLinkListWithBound-->");
	}

	@Test
	public void testReverseLinkList() {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(4);
		head.next.next.next.next = new LinkedListNode(5);
		print(head);
		head = reverseLinkList(head);
		print(head);
	}
	
	static LinkedListNode deleteNode(LinkedListNode head, int value) {
		if(head == null){
			return head;
		}
		
		if(head.value == value){
			return head.next;//moved head to next and deleted head
		}
		
		LinkedListNode current = head;
		while(current.next != null){
			if(current.next.value == value){
				current.next = current.next.next;
				return head;//no need to change head
			}
			current = current.next;
		}
		
		return head;//value not found nothing deleted
	}
	
	static void appendToEnd(LinkedListNode head, int data){
		LinkedListNode newEndNode = new LinkedListNode(data);
		if(head == null){
			head = newEndNode;
			return;
		}
		
		LinkedListNode current = head;
		while(current.next != null){
			current = current.next;
		}
		
		current.next = newEndNode;
	}

}
