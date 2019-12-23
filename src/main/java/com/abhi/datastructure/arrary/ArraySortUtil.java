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


}
