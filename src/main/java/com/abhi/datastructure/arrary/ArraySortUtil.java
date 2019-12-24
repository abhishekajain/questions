package com.abhi.datastructure.arrary;

import java.util.Arrays;
import java.util.Random;

public class ArraySortUtil {	
	
	private Random random = new Random();
	private int[] elements;
	private int size;
	
	public ArraySortUtil(int size) {
		this.size = size;
		this.elements = new int[size];
		for(int i=0; i<this.size; i++) {
			this.elements[i] = this.random.nextInt(100) + 1;
		}
	}
	
	public int[] getElements() {
		return this.elements;
	}
	
	public void printArray() {
		System.out.println(Arrays.toString(this.elements));
	}
	
	public void selectionSort() {
//		this.printArray();
		int unSortedIndex = this.size-1;
		while(unSortedIndex > 0) {
			this.swapLargestElement(unSortedIndex--);
		}
//		this.printArray();
	}
	
	private void swap(int a, int b) {
		int elementA = this.elements[a];
		this.elements[a] = this.elements[b];
		this.elements[b] = elementA;
	}
	
	private void swapLargestElement(int unSortedIndex) {
		int largestElementIndex = 0;
		for(int i=1; i<=unSortedIndex; i++) {
			if(this.elements[largestElementIndex]<this.elements[i]) {
				largestElementIndex = i;
			}
		}
		if(largestElementIndex != unSortedIndex) {
			this.swap(largestElementIndex, unSortedIndex);
		}
	}
	
	public void insertionSort(){
		this.printArray();
		for(int i=1; i<this.size; i++) {
			this.insert(i, this.elements[i]);
		}
		this.printArray();
	}
	
	private void insert(int sortedIndex, int element) {
		boolean isInserted = false;
		while(sortedIndex > 0) {
			if(this.elements[sortedIndex-1] > element) {
//				shift one element to right mean up
				this.elements[sortedIndex] = this.elements[sortedIndex-1];
			}else if(this.elements[sortedIndex-1] <= element) {
//				found insertion point
				this.elements[sortedIndex] = element;
				isInserted = true;
				break;
			}
			sortedIndex--;
		}
		if(!isInserted) {
//			no insertion point found and reach to end of array
			this.elements[0] = element;
		}
	}
	
	


}
