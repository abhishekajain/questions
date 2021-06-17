package com.abhi.list.linkedlist;

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	
	private int size = 0;
	
	public void addToFront(int value) {
		Node node = new Node(value);
		node.setNext(this.head);
		if(this.head != null) {
			this.head.setPrevious(node);
		}else {
			this.tail = node;
		}
		this.head = node;
		this.size++;
	}
	
	public boolean isEmppty() {
		return this.head == null;
	}
	
	public Node removeFromFront() {
		Node node = this.head;
		if(node != null) {
			this.head = node.getNext();
			node.setNext(null);
			this.head.setPrevious(null);
			this.size--;
		}
		return node;
	}

	public int getSize() {
		return size;
	}
	
	public void addToEnd(int value) {
		Node node = new Node(value);
		node.setPrevious(this.tail);
		if(this.tail != null) {
			this.tail.setNext(node);
		}else {
			this.head = node;
		}
		this.tail = node;
		this.size++;
	}
	
	public Node removeFromEnd() {
		Node node = this.tail;
		if(node != null) {
			this.tail = node.getPrevious();
			node.setPrevious(null);
			this.size--;
		}
		return node;
	}

}
