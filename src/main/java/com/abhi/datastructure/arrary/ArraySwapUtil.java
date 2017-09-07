package com.abhi.datastructure.arrary;

import org.junit.Test;

public class ArraySwapUtil {

	// Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra
	// space
	// Given an array arr[] of size n where every element is in range from 0 to
	// n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]]. This
	// should be done with O(1) extra space.
	//
	// Examples:
	//
	// Input: arr[] = {3, 2, 0, 1}
	// Output: arr[] = {1, 0, 3, 2}
	//
	// Input: arr[] = {4, 0, 2, 1, 3}
	// Output: arr[] = {3, 4, 2, 0, 1}
	//
	// Input: arr[] = {0, 1, 2, 3}
	// Output: arr[] = {0, 1, 2, 3}
	// If the extra space condition is removed, the question becomes very easy.
	// The main part of the question is to do it without extra space.
	
	public static void rearrangeArray(int[] input){
		int n = input.length;//4
		for(int i=0; i<n ;i++){
			System.out.println(input[input[i]]%n);
			System.out.println((input[input[i]]%n)*n);
			input[i] = 	input[i]+(input[input[i]]%n)*n ;
		}
		
		// Second Step: Divide all values by n
	    for (int i=0; i<n; i++)
	    	input[i] = input[i]/n;
	}
	
	@Test
	public void testrearrangeArray(){
		int arr[] = {3, 2, 0, 1};
		rearrangeArray(arr);
	}

}
