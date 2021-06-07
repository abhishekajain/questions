package com.abhi.ten.one.stack.queue;

public class QueueTwoStacks {
	
	Stack stackPush;	
	Stack stackPop;
	
	public QueueTwoStacks(int capacity) {
		stackPop = new Stack(capacity);
		stackPush = new Stack(capacity);
	}
	
	public int enqueue(int element) {
		if(stackPop.isEmpty()) {
			return stackPop.push(element);
		}
		return stackPush.push(element);
	}
	
	public int dequeue() {
		if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}		
		return stackPop.pop();
	}
	
	public boolean isEmpty() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			return true;
		}
		return false;
	}
	
	

}
