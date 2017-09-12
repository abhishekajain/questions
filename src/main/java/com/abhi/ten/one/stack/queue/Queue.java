package com.abhi.ten.one.stack.queue;

public class Queue {
	
	int[] elements;
	
	int size;
	
	int head=0;
	int tail=0;
	
	public Queue(int size) {
		this.size = size;
		this.elements = new int[this.size];
	}
	
	public int enqueue(int element) {
		this.elements[tail] = element;
		if(tail == size-1) {
			tail = 0;
		}else {
			tail = tail +1;
		}
		return element;
	}
	
	public int dequeue() {
		int element = this.elements[head];
		this.elements[head] = 0;
		if(head == size-1) {
			head = 0;
		}else {
			head = head +1;
		}
		return element;
	}
	
	public boolean isEmpty() {
		if(this.head == this.tail) {
			return true;
		}
		return false;
	}

}
