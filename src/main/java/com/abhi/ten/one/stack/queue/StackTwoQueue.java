package com.abhi.ten.one.stack.queue;

public class StackTwoQueue {
	
	Queue q1;
	Queue q2;//always keep q2 empty

	public StackTwoQueue(int size) {
		q1 = new Queue(size);
		q2 = new Queue(size);
	}
	
	public int push(int element) {
		q2.enqueue(element);//adding top element and then add all other element on the top
		
		while(!q1.isEmpty()) {//making q1 empty
			q2.enqueue(q1.dequeue());
		}
		
		Queue temp = q1;
		q1=q2;
		q2=temp;//now moved empty q1 to q2 mean q2 is empty again.
		return element;
	}
	
	public int pop() {
		return q1.dequeue();
	}

}
