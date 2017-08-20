package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayUtil {
	
	static Integer[] mergeSortedAaary(int[] a, int[] b){
		int aL = a.length;
		int bL = b.length;
		
		Integer[] c = new Integer[aL+bL];
		
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
	
	@Test
	public void testMergeSortedArray() {
		int[] a = {1,2,3,4,5};
		int[] b = {3,5,8};

		Integer[] c = mergeSortedAaary(a, b);
		
		List<Integer> list = Arrays.asList(c);
		System.out.println(list);
	}
	
	static List<List<Integer>> combinations(int amount, List<Integer> denominations){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for(Integer denomination:denominations){
			if(amount<denomination){
				continue;
			}
			int rem = amount%denomination;
			int howMany = amount/denomination;
			List<Integer> resultMany = new ArrayList<Integer>();
			for(int i=0; i<howMany; i++){
				resultMany.add(denomination);
			}

			if(rem == 0){
				results.add(resultMany);
			}else{
				//Recursion for remaining money
				List<List<Integer>> newResults = combinations(rem, denominations);				
				//merge results in resultMany
				for(List<Integer> result:newResults){
					List<Integer> list = new ArrayList<Integer>(resultMany);
					list.addAll(result);
					results.add(list);					
				}
			}
		}
		return results;
		
	}
	
	@Test
	public void testCombinations(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);

		List<List<Integer>> results = combinations(32, list);
		results.stream().forEach(l ->{
			System.out.println(l);
		});
	}
}
