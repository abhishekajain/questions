package com.abhi.tree.binarysearch;

import org.junit.Test;

public class ArrayQuestion {
	
	public static int supperEggDrops(int K, int N) {		
//		if only one floor
		if(N == 0 || N == 1) {
			return 1;
		}
//		if only one egg give
		if(K == 1) {
			return N;
		}
//		lets go for worst condition assuming we have enough eggs
		int r = N;
		int trial = 0;
		while(r>1 && trial<K-1) {
			r = (r/2)-1;
			trial+=1; 
		}
		
		return trial+r+1;
	}
	
	@Test
	public void testSupperEggDrops() {
		System.out.println(supperEggDrops(4, 14));
		System.out.println(supperEggDrops(2, 14));
		System.out.println(supperEggDrops(2, 7));


	}

}
