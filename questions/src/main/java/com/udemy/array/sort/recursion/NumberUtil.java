package com.udemy.array.sort.recursion;

public class NumberUtil {
	
	/**
	 * 0! = 1
	 * 1! = 1*0!
	 * 2! = 2*1!
	 * 3! = 3*2!
	 * 4! = 4*3!
	 * 5! = 5*4!
	 * 
	 * n! = n*(n-1)!
	 * @param input
	 * @return
	 */
	
	public static long recursiveFactorial(int input) {
		if(input < 0) {
			throw new IllegalArgumentException("less than zero not allowed.");
		}
//		this to cover 0 and 1
		if(input <= 1) {
			return 1l;
		}
		return input*recursiveFactorial(input-1);
	}
	
	
	public static long calculateFactorial(int input) {
		if (input < 0) {
			throw new IllegalArgumentException("less than zero not allowed.");
		}
//		this to cover 0 and 1
		if (input <= 1) {
			return 1l;
		}
		long result = 1l;
		for(int i=2; i<=input; i++) {
			result = multiply(result, i);
		}
		
		return result;
	}
	
	private static long multiply(long number, int input) {
		return number*input;
	}

}
