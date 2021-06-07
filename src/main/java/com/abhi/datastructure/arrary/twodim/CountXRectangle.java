package com.abhi.datastructure.arrary.twodim;

public class CountXRectangle {

	public static void main(String[] args) {
		char[][] mat3 = { 
				{ 'O', 'O', 'O' }, 
				{ 'X', 'X', 'O' }, 
				{ 'X', 'X', 'O' }, 
				{ 'O', 'O', 'X' }, 
				{ 'O', 'O', 'X' },
				{ 'X', 'X', 'O' } };
		// Output: Number of Rectangle is 3
		System.out.println(countXRectangle(mat3));
		char[][] mat4 = { 
				{ 'X', 'O', 'O', 'O', 'O', 'O' }, 
				{ 'X', 'O', 'X', 'X', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'O', 'O' }, 
				{ 'X', 'X', 'X', 'O', 'X', 'X' }, 
				{ 'X', 'X', 'X', 'O', 'X', 'X' },
				{ 'O', 'O', 'O', 'O', 'X', 'X' }, };
		// Output: Number of Rectangle is 4
		System.out.println(countXRectangle(mat4));

	}
	
	public static int countXRectangle(char[][] mat) {
		int count = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; i < mat.length && j < mat[i].length; j++) {
				if (mat[i][j] == 'X') {
					if ((i == 0 || mat[i - 1][j] == 'O') && (j == 0 || mat[i][j - 1] == 'O')) {
						count++;
					}
				}

			}
		}
		return count;
	}

}
