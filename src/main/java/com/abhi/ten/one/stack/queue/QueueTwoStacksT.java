package com.abhi.ten.one.stack.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueTwoStacksT<T> {

	Stack<T> stackPush = new Stack<T>();
	Stack<T> stackPop = new Stack<T>();

	T enqueue(T element) {
		return stackPush.push(element);
	}

	T dequeue() {
		if (stackPop.isEmpty()) {
			while (stackPush.size() > 1) {
				stackPop.push(stackPush.pop());
			}
			if (stackPush.size() == 1) {
				return stackPush.pop();
			} else {
				throw new NoSuchElementException("empty queue!");
			}
		} else {
			return stackPop.pop();
		}
	}
}
