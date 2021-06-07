package com.abhi.list.linkedlist;

public class LinkedList {
	
	private Node head = null;
	private Node tail = null;
	
	private int size = 0;

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}
	
	public void print() {
		System.out.println();
		System.out.print("Print-->");
		Node current = this.head;
		while(current != null) {
			System.out.print(current.getValue()+"-->");
			current = current.getNext();
		}
		System.out.print("size-->"+this.size);
	}
	
	public void addToFront(int value) {
		Node node = new Node(value);
		node.setNext(this.head);
		if(this.head == null) {
			this.tail = node;
		}
		this.head = node;
		this.size++;
	}
	
	public void addToEnd(int value) {
		Node node = new Node(value);
		if(this.tail != null) {
			this.tail.setNext(node);
		}else {
			this.head = node;
		}
		this.tail = node;
		this.size++;
	}
	
	public Node removeFromFront(){
		Node head = this.head;
		if(head != null) {
			this.head = head.getNext();
			head.setNext(null);
			this.size--;
		}
		return head;
	}
	
	private Node oneBeforeEnd() {
		Node current = this.head;
		Node previous = this.head;
		while(current != null && current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		if(current == previous) {
			return null;
		}
		return previous;
	}
	
	public Node removeFromEnd() {
		Node previous = this.oneBeforeEnd();
		if(previous != null) {
			previous.setNext(null);
			this.size--;
		}else {
			this.head = previous;
		}		
		Node tail = this.tail;
		this.tail = previous;
		return tail;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}

}
