package com.abhi.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

//linked list cycle mean node is poiting to element that already traversed in the list.
//this mean it is same object instance when comparing == will work for those two listnode

//TODO how to remove loop what does it mean by removing loop
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		// checking if list is empty
		if (head == null || head.next == null) {
			return false;
		}

		Set<ListNode> values = new HashSet<ListNode>();
		while (head.next != null) {
			// adding next node to set if it already part of set adding to set will be
			// returning false.
			// this mean linked list has cycle, otherwise if last element next is null no
			// cycle with the list
			if (!values.add(head)) {
				return true;
			}
			head = head.next;
		}

		return false;
	}

	public boolean hasCycleNoSpace(ListNode head) {
		// linked list is empty
		if (head == null || head.next == null) {
			return false;
		}
		// making two pointer one slow and one fast
		// if fast reaches to null linked list does not have any loop
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			// if linked list has loop they will meet fast and slow and once they meet
			// we can end the loop by saying linked list has cycle.
			if (fast == slow) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
