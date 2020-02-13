package com.abhi.ten.one.stack.queue;

import java.util.NoSuchElementException;

public class TwoStack {
	
	int[] elements;
	
	int size;
	
	int[] top = new int[2];
	
	public TwoStack(int size) {
		this.size = size;
		
		this.elements = new int[this.size];
		
		top[0] = -1;
		top[1] = this.size;
		
	}
	
	public boolean isEmpty() {
		if(this.top[0] == -1 && this.top[1] == this.size) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(int index) {
		if(index == 0 && this.top[0] == -1) {
			return true;
		} else if(index == 1 && this.top[1] == this.size) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(this.top[0] == this.top[1]) {
			return true;
		}
		return false;
	}
	
	public int push(int element, int index) {
		if(isFull()) {
			throw new IllegalArgumentException("Stack is full");
		}
		
		if(index == 0) {
			top[index] = top[index]+1;
		}else if(index == 1) {
			top[index] = top[index]-1;
		}		
		elements[top[index]] = element;
		
		return element;
	}
	
	public int pop(int index) {
		if(isEmpty(index)) {
			throw new NoSuchElementException("This stack is empty :"+index);
		}
		
		int element = elements[top[index]];
		elements[top[index]] = 0;
		
		if(index == 0) {
			top[index] = top[index]-1;
		} else if(index == 1) {
			top[index] = top[index]+1;
			return element;
		}
		return element;
		
	}
	
	public int peek(int index) {
		if(isEmpty(index)) {
			throw new NoSuchElementException("This stack is empty :"+index);
		}
		return elements[top[index]];			
		
	}

}
