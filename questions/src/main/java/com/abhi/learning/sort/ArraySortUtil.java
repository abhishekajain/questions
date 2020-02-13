package com.abhi.learning.sort;

public class ArraySortUtil {
	
	
	public static int[] selectionSort(int[] input) {
		int lastUnsortedIndex = input.length;

		
		while(lastUnsortedIndex != 1) {
			int largestElementIndex = 0;
			int largestElement = input[largestElementIndex];			
			for(int i=1; i<lastUnsortedIndex; i++) {
				if(input[i]>largestElement) {
					largestElement = input[i];
					largestElementIndex = i;
				}
			}
			input[largestElementIndex] = input[lastUnsortedIndex-1];
			input[lastUnsortedIndex-1] = largestElement;
			lastUnsortedIndex--;
		}
				
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = {20, 35, -15, 7, 55, 1, -22};
		input = selectionSort(input);
		System.out.println(input);
	}

}
