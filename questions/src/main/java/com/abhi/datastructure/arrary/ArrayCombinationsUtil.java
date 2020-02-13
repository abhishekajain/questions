package com.abhi.datastructure.arrary;

public class ArrayCombinationsUtil {

	public static int[][] createCombinations(int[] input, int numberOfElementsinCombination) {
		int inputArraySize = input.length;
		int[][] result = new int[NCX(inputArraySize, numberOfElementsinCombination)][numberOfElementsinCombination];
		int totalCombninations = NCX(inputArraySize, numberOfElementsinCombination);
		int j = -1 ;
		for(int i=0; i<totalCombninations;i++){
			result[i] = new int[numberOfElementsinCombination];
			if(j >= inputArraySize-1){
				j = -1;
			}
			System.err.println(j);
			result[i][0] = input[++j];
			if(j >= inputArraySize-1){
				j = -1;
			}
			result[i][1] = input[++j];
			if(j >= inputArraySize-1){
				j = -1;
			}
			result[i][2] = input[++j];
		}
		return result;
	}

	public static int NCX(int N, int X) {
		int factorialN = factorial(N);
		int factorialX = factorial(X);
		int factorialSubtraction = factorial(N-X);
		int result = factorialN / (factorialX*factorialSubtraction);
		return result;
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int fact = 1; // this will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	public static void print(int[][] result) {
		for(int i=0; i<result.length; i++){
			System.out.println("");
			print(result[i]);
		}
	}
	
	private static void print(int[] input) {
		for (int j = 0; j < input.length; j++) {
			System.out.print(input[j] + ",");
		}
	}
	
	public static void main(String[] args) {
		int[] input = { 0, -1, 56, 2, -3, 1 };
		print(ArrayCombinationsUtil.createCombinations(input, 3));
	}

}
