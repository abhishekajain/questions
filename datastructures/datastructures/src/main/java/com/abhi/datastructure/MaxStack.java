package com.abhi.datastructure;

import java.util.Stack;

public class MaxStack {
	
	private Stack<Integer> stack = new Stack<Integer>();
	
	public int getMaxOptimizedForSpace(){
		Stack<Integer> tempStack = new Stack<Integer>();
		int maxElement = Integer.MIN_VALUE;
		while(!stack.empty()){
			if(stack.peek()>maxElement){
				maxElement = stack.peek();
			}
			tempStack.push(stack.pop());
		}
		
		while(!tempStack.empty()){
			stack.push(tempStack.pop());
		}
		
		return maxElement;
	}

	
	private Stack<Integer> maxElementStack = new Stack<Integer>();//additional space used


	public int getMax(){	//optimized for time not space	
		return maxElementStack.peek();
	}
	
	public Integer push(Integer element){
		if(maxElementStack.empty() || maxElementStack.peek()<=element){
			maxElementStack.push(element);
		}
		return stack.push(element);
	}
	
	public Integer pop(){
		Integer element = stack.pop();
		if(element == maxElementStack.peek()){
			maxElementStack.pop();
		}
		return element;
	}
	
	public Integer peek(){
		return stack.peek();
	}
}
