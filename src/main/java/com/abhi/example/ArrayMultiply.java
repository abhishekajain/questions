package com.abhi.example;

/**
 * You have an array of integers, and for each index you want to find the
 * product of every integer except the integer at that index. Write a function
 * getProductsOfAllIntsExceptAtIndex() that takes an array of integers and
 * returns an array of the products.
 * [1, 7, 3, 4] 
 * [84, 12, 28, 21]
 * [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
 * @author abhishek.ajain
 *
 */

public class ArrayMultiply {
	
	public static void main(String[] args){
		int[] input = {1, 7, 3, 4};
		Util.printArray(getProductsOfAllIntsExceptAtIndex(input));

	}
	
	public static long[] getProductsOfAllIntsExceptAtIndex(int[] input){
		long[] result = new long[input.length];
		for(int i=0;i<input.length;i++){
			result[i]= getProductsOfAllIntsExceptAtIndex(input, i);		
		}
		return result;
		
	}
	
	public static long getProductsOfAllIntsExceptAtIndex(int[] input, int index){
		long result = 1;
		for(int i=0;i<input.length;i++){
			if(i!=index){
				result = result * input[i];		
			}			
		}
		return result;
		
	}

}
