package com.abhi.ten.two.linkedlist;

public class LinkedList {
	
	Node head;
	//adding new element to list is front of the list
	public static void insert(LinkedList list, Node element) {
		element.next = list.head;
		if(list.head != null) {
			list.head.prev = element;
		}else {
			list.head = element;
			list.head.prev = null;
		}		
	}
	
	public static Node search(LinkedList list, int key) {
		Node current = list.head;
		while(current != null && current.key != key) {
			current = current.next;
		}
		return current;
	}
	
	public static void delete(LinkedList list, Node element) {
		if(element.prev != null) {		
			element.prev.next = element.next;
		}else {
			list.head = element.next;
		}
		
		if(element.next != null) {
			element.next.prev = element.prev;
		}				
	}

}
