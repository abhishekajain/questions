package com.abhi.ten.one.stack.queue;

import java.util.NoSuchElementException;

public class NStack {
	
	int[] elements;
	
	int sizeOfEachStack;
	int numberOfStacks;
	
	int[] top;
	
	public NStack(int sizeOfEachStack, int numberOfStacks) {
		this.sizeOfEachStack = sizeOfEachStack;
		this.numberOfStacks = numberOfStacks;
		
		this.elements = new int[this.sizeOfEachStack*this.numberOfStacks];
		this.top = new int[this.numberOfStacks];
		
		for(int topIndex = 0; topIndex<this.numberOfStacks; topIndex++) {
			this.top[topIndex] = this.sizeOfEachStack*topIndex-1;
		}
	}
	
	public boolean isStackEmpty(int index) {
		if(this.top[index] == (sizeOfEachStack*index-1)) {
			return true;
		}
		return false;
	}
	
	public int push(int element, int index) {
		if(top[index] == sizeOfEachStack*(index+1)) {
			throw new IllegalArgumentException("This stack is full :"+index);
		}
		
		int pushIndex = top[index]+1;
		this.elements[pushIndex] = element;
		top[index] = pushIndex;
		return element;
	}
	
	public int pop(int index) {
		if(isStackEmpty(index)) {
			throw new NoSuchElementException();
		}
		int popIndex = top[index];
		int element = this.elements[popIndex];
		top[index] = popIndex-1;
		return element;
	}
	
	public int peek(int index) {
		if(isStackEmpty(index)) {
			throw new NoSuchElementException();
		}
		int peekIndex = top[index];
		int element = this.elements[peekIndex];
		return element;
	}


}
