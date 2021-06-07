package com.abhi.datastructure.arrary;

public class LargestSquareOfOne {
	
	public static void main(String[] args) {
		int[][] matrix ={	{1,1,0,1,0},
							{0,1,1,1,0},
							{1,1,1,1,0},
							{0,1,1,1,0},
							{1,1,1,1,1}
						};
		
		System.out.println("largestSeq>>>"+largestSequare(matrix));
		
		int[][] matrix2 = {	
				{1,1,0,1,0,1},
				{0,1,1,1,0,1},
				{1,1,1,1,0,1},
				{0,1,1,1,0,1},
				{1,1,1,1,1,1}
			};

		System.out.println("largestSeq>>>"+largestSequare(matrix2));
		
		int[][] matrix3 = {	
				{1,1,0,1,0,1},
				{0,1,1,1,0,1},
				{1,1,1,1,1,1},
				{0,1,1,1,1,1},
				{1,1,1,1,1,1},
				{1,1,1,1,1,1}
			};

		System.out.println("largestSeq>>>"+largestSequare(matrix3));
	}
	
	public static int largestSequare(int[][] matrix) {
		print(matrix);
		int x = matrix.length;
		int y = matrix[0].length;
		int[][] cache = new int[x][y];
		int largestSeq = 0;
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				//when i or j any of these are zero calculated is itself
				if(i==0 || j==0) {
					cache[i][j] = matrix[i][j];
				}//else it will be minimum or all neighbor plus itself (
				else {
					cache[i][j]= matrix[i][j]+Math.min(cache[i][j-1], Math.min(cache[i-1][j-1], cache[i-1][j]));
					if(cache[i][j]>largestSeq) {
						largestSeq = cache[i][j];
					}
				}
			}
		}
		print(cache);
		return largestSeq;
	}
	
	public static void print(int[][] matrix) {
		System.out.println("{");
		for(int i=0; i<matrix.length; i++) {
			System.out.println("{");
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]+", ");
			}
			System.out.println("}");
		}
		System.out.println("}");
	}

}
