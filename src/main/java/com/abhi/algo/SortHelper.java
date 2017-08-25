package com.abhi.algo;

import org.junit.Test;

public class SortHelper {
	/**
	 * 1 for j = 2 to A.length 
	 * 2 key = A[j] 
	 * // Insert A[j] into the sorted sequence A [1 .. j-1]. 
	 * 3 i = j - 1 
	 * 4 while i > 0 and A[i] > key 
	 * 5 A[i+1] = A[i] 
	 * 6 A[i] = key 
	 * 7 i--
	 * 
	 * @param input
	 * @return
	 */
	public static int[] insertionSort(int[] input) {
		for (int j = 1; j < input.length; j++) {
			int key = input[j];
			int i = j - 1;
			while (i >= 0 && input[i] > key) {
				input[i + 1] = input[i];
				input[i] = key;
				i--;
			}
		}
		return input;
	}

	@Test
	public void tesinsertionSort() {
		int[] input = { 0, -1, 56, 2, -3, 1 };
		print(input);
		System.out.println("");
		print(SortHelper.insertionSort(input));
	}

	private static void print(int[] input) {
		for (int j = 0; j < input.length; j++) {
			System.out.print(input[j] + ",");
		}
	}

}
