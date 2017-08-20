package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.Test;

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
	
	@Test
	public void testMergeSortedArray() {
		int[] a = {1,2,3,4,5};
		int[] b = {3,5,8};

		int[] c = mergeSortedAaary(a, b);
		System.out.println(c);
	}
	
	static List<int[]> combinations(int amount, List<Integer> denominations){
		List<int[]> results = new ArrayList<int[]>();
		Collections.sort(denominations);
		for(Integer denomination:denominations){
			if(amount<denomination){
				continue;
			}
			int rem = amount%denomination;
			int howMany = amount/denomination;
			int[] resultMany = new int[howMany];
			for(int i=0; i<resultMany.length; i++){
				resultMany[i] = denomination;
			}

			if(rem == 0){
				results.add(resultMany);
			}else{
				//Recursion for remaining money
				List<Integer> newList = new ArrayList<Integer>(denominations);
				newList.remove(denomination);
				List<int[]> newResults = combinations(rem, newList);
				
				//merge results
				for(int[] result:newResults){
					int[] newResultsArr = new int[howMany+result.length];
					for(int i=0; i<resultMany.length;i++){
						newResultsArr[i] = resultMany[i];
					}
					int j = 0;
					for(int i=resultMany.length; i<newResultsArr.length; i++){
						newResultsArr[i] = result[j];
						j++;
					}
					results.add(newResultsArr);
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
		List<int[]> results = combinations(32, list);
		System.out.println(results);
	}
}
