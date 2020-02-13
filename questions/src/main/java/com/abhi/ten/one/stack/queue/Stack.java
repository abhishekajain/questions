package com.abhi.ten.one.stack.queue;

import java.util.NoSuchElementException;

import org.junit.Test;

public class Stack {
	
	int[] elements;
	
	int size;
	
	int top = -1;
	
	public Stack(int size) {
		this.size = size;
		this.elements = new int[size];
		
	}
	
	public int push(int element) {
		if(isFull()) {
			throw new IllegalArgumentException("Stack is full");
		}
		elements[++top] = element;
		return element;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		int element = elements[top];
		elements[top--] = 0;
		return element;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Stack is empty");
		}
		
		return elements[top];
	}
	
	public boolean isEmpty() {
		if(this.top == -1) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		if(top == size -1) {
			return true;
		}
		return false;
	}
	
	@Test
	public void testPush() {
		
	}

}
