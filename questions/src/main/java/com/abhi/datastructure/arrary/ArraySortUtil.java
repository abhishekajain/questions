package com.abhi.datastructure.arrary;

import java.util.Arrays;
import java.util.Random;

public class ArraySortUtil {	
	
	private Random random = new Random();
	private int[] elements;
	private int[] sortedElements;
	private int size;
	
	public ArraySortUtil(int size) {
		this.size = size;
		this.elements = new int[size];
		this.sortedElements = new int[size];
		for(int i=0; i<this.size; i++) {
			this.elements[i] = this.random.nextInt(100) + 1;
			this.sortedElements[i] = this.elements[i];
		}
		Arrays.sort(this.sortedElements);
	}
	
	public int[] getElements() {
		return this.elements;
	}
	
	public int[] getSortedElements() {
		return this.sortedElements;
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
	
	public void insertionSort(int gap){
		for(int i=gap; i<this.size; i++) {
			this.insertion(i, this.elements[i], gap);
		}
	}
	
	private void insert(int sortedIndex, int element) {
		boolean isInserted = false;
		while(sortedIndex > 0 && !isInserted) {
			if(this.elements[sortedIndex-1] > element) {
//				shift one element to right mean up
				this.elements[sortedIndex] = this.elements[sortedIndex-1];
			}else if(this.elements[sortedIndex-1] <= element) {
//				found insertion point
				this.elements[sortedIndex] = element;
				isInserted = true;
			}
			sortedIndex--;
		}
		if(!isInserted) {
//			no insertion point found and reach to end of array
			this.elements[0] = element;
		}
	}
	
	private void insertion(int sortedIndex, int element, int gap) {
//		for loop to find insertion point
//		insertion point at the end of the array
//		insertion point if before element is less than equal to element
		while(sortedIndex >= gap && this.elements[sortedIndex-gap] > element) {
//			shift one element to right/up until find insertion point
			this.elements[sortedIndex] = this.elements[sortedIndex-gap];
			sortedIndex -= gap;
		}
//		found insertion point
		this.elements[sortedIndex] = element;
	}
	
	public void shellSort() {
		for(int gap = this.size/9; gap >= 0; gap /= 9) {
			if(gap == 0) {
				gap = 1;
			}
			this.insertionSort(gap);
			if(gap == 1) {
				break;
			}
		}			
	}
}
