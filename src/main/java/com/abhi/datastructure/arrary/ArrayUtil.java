package com.abhi.datastructure.arrary;

public class ArrayUtil {
	
	static int[] mergeSortedAaary(int[] a, int[] b){
		int aL = a.length;
		int bL = b.length;
		
		int[] c = new int[aL+bL];
		
		int countA  = 0;
		int countB = 0;
		int countC = 0;
		while(countA<aL || countB<bL){
			if(countA<aL && countB<bL && a[countA]<b[countB]){
				c[countC] = a[countA];
				countA++;
				countC++;
			} else if(countA<aL && countB<bL && b[countB]<a[countA]){
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if(countA<aL && countB<bL &&  b[countB] == a[countA]){
				c[countC] = a[countA];
				countA++;
				countC++;
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if (countA == aL){
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if (countB == bL){
				c[countC] = a[countA];
				countA++;
				countC++;
			}
		}
		return c;		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int[] b = {3,5,8};

		int[] c = ArrayUtil.mergeSortedAaary(a, b);
		System.out.println(c);
	}
}
