package com.abhi.datastructure.arrary;

import org.junit.Test;

/**
 * String[] words = new String[]{ "ptolemaic", "retrograde", "supplant",
 * "undulate", "xenoepist", "asymptote", // <-- rotates here! "babka",
 * "banoffee", "engender", "karpatka", "othellolagkage", };
 * 
 * I want to learn some big words so people think I'm smart. I opened up a
 * dictionary to a page in the middle and started flipping through, looking for
 * words I didn't know. I put each word I didn't know at increasing indices in a
 * huge array I created in memory. When I reached the end of the dictionary, I
 * started from the beginning and did the same thing until I reached the page I
 * started at.
 * 
 * Now I have an array of words that are mostly alphabetical, except they start
 * somewhere in the middle of the alphabet, reach the end, and then start from
 * the beginning of the alphabet. In other words, this is an alphabetically
 * ordered array that has been "rotated." For example: Write a function for
 * finding the index of the "rotation point," which is where I started working
 * from the beginning of the dictionary. This array is huge (there are lots of
 * words I don't know) so we want to be efficient here.
 * 
 * @author abhishek.ajain
 *
 */

public class RotationPoint {

	@Test
	public void test() {
		String[] words = new String[] { "p", "q", "r", "s", "t", "u", "x", "y", "a", // <--
																						// rotates
																						// here!
																						// "babka",
				"b", "e", "k", "o", };
		System.out.println(rotationIndex(words, 0, words.length - 1));
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of
	 * 6)
	 */
	static int findPivotNew(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}
	
	public static int rotationIndex(String[] strArray, int low, int high) {
		int middle = (high+low)/2;
		
		String str = strArray[middle];
		String strMP1 = strArray[middle + 1];
		String strMM1 = strArray[middle - 1];
		int compareMM1 = str.compareTo(strMM1);
		int compareMP1 = str.compareTo(strMP1);
		
		if (compareMM1 > 0 && compareMP1 > 0) {
			return middle;
		} else if (compareMM1 < 0 && compareMP1 > 0) {
			return rotationIndex(strArray, low, middle-1);
		} else if (compareMM1 > 0 && compareMP1 < 0) {
			return rotationIndex(strArray, middle + 1, high);
		} else {
			return middle;
		}
	}

	/*
	 * Searches an element key in a pivoted sorted array arrp[] of size n
	 */
	static int pivotedBinarySearch(int arr[], int n, int key) {
		int pivot = findPivot(arr, 0, n - 1);

		// If we didn't find a pivot, then
		// array is not rotated at all
		if (pivot == -1)
			return binarySearch(arr, 0, n - 1, key);

		// If we found a pivot, then first
		// compare with pivot and then
		// search in two subarrays around pivot
		if (arr[pivot] == key)
			return pivot;
		if (arr[0] <= key)
			return binarySearch(arr, 0, pivot - 1, key);
		return binarySearch(arr, pivot + 1, n - 1, key);
	}

	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of
	 * 6)
	 */
	static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}

	/* Standard Binary Search function */
	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	@Test
	public void testpivotedBinarySearch() {
		// Let us search 3 in below array
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int n = arr1.length;
		int key = 3;
		System.out.println("Index of the element is: " + pivotedBinarySearch(arr1, n, key));
	}

}
