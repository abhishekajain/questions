package com.udemy.array.sort;

import java.util.Random;

public class ArraySortUtil {
	
	private int[] elements;
	private Random random = new Random();
	
	public ArraySortUtil(int items) {
		this.elements = new int[items];
		for(int i=0; i<items; i++) {
			this.elements[i] = this.random.nextInt(100);
		}
	}
	
	public void bubbleSort() {
		for(int unsortedIndex = this.elements.length-1; unsortedIndex>0; unsortedIndex--) {
			for(int i=0; i<unsortedIndex; i++) {
				if(this.elements[i] > this.elements[i+1]) {
					swap(i, i+1);
				}
			}
		}
	}
	
	public void swap(int i, int j) {
		if(i==j) {
			return;
		}
		int eleI = this.elements[i];
		this.elements[i] = this.elements[j];
		this.elements[j] = eleI;
	}
	
	public void printArray() {
		System.out.print("start:");
		for(int i:this.elements) {
			System.out.print(i+"-->");
		}
		System.out.println(":end");
	}
	
	public static void main(String[] args) {
		ArraySortUtil util = new ArraySortUtil(6);
		util.printArray();
		util.bubbleSort();
		util.printArray();
	}

}
