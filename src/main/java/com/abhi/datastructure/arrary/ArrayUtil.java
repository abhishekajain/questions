package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtil {

	static Integer[] mergeSortedAaary(int[] a, int[] b) {
		int aL = a.length;
		int bL = b.length;

		Integer[] c = new Integer[aL + bL];

		int countA = 0;
		int countB = 0;
		int countC = 0;
		while (countA < aL || countB < bL) {
			if (countA < aL && countB < bL && a[countA] < b[countB]) {
				c[countC] = a[countA];
				countA++;
				countC++;
			} else if (countA < aL && countB < bL && b[countB] < a[countA]) {
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if (countA < aL && countB < bL && b[countB] == a[countA]) {
				c[countC] = a[countA];
				countA++;
				countC++;
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if (countA == aL) {
				c[countC] = b[countB];
				countB++;
				countC++;
			} else if (countB == bL) {
				c[countC] = a[countA];
				countA++;
				countC++;
			}
		}
		return c;
	}

	@Test
	public void testMergeSortedArray() {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 3, 5, 8 };

		Integer[] c = mergeSortedAaary(a, b);

		List<Integer> list = Arrays.asList(c);
		System.out.println(list);
	}

	static List<List<Integer>> combinations(int amount, List<Integer> denominations) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (Integer denomination : denominations) {
			if (amount < denomination) {
				continue;
			}
			int rem = amount % denomination;
			int howMany = amount / denomination;
			List<Integer> resultMany = new ArrayList<Integer>();
			for (int i = 0; i < howMany; i++) {
				resultMany.add(denomination);
			}

			if (rem == 0) {
				results.add(resultMany);
			} else {
				// Recursion for remaining money
				List<List<Integer>> newResults = combinations(rem, denominations);
				// merge results in resultMany
				for (List<Integer> result : newResults) {
					List<Integer> list = new ArrayList<Integer>(resultMany);
					list.addAll(result);
					results.add(list);
				}
			}
		}
		return results;

	}

	static long highestProduct(int[] input) throws IllegalArgumentException {
		long result = 1l;
		if (input.length < 3) {
			throw new IllegalArgumentException();
		}
		if (input.length == 3) {
			for (int i : input) {
				result = result * i;
			}
		} else {
			Arrays.sort(input);
			result = Math.max(input[0] * input[1] * input[input.length - 1],
					input[input.length - 3] * input[input.length - 2] * input[input.length - 1]);
		}

		return result;
	}

	static long highestProductWithoutSort(int[] input) {
		long result = 1l;
		if (input.length < 3) {
			throw new IllegalArgumentException();
		}
		if (input.length == 3) {
			for (int i : input) {
				result = result * i;
			}
		} else {
			// Initialize Maximum, second maximum and third
			// maximum element
			int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

			// Initialize Minimum and second minimum element
			int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

			for (int i : input) {
				if (i > maxA) {
					maxC = maxB;
					maxB = maxA;
					maxA = i;
				} else if (i > maxB) {
					maxC = maxB;
					maxB = i;
				} else if (i > maxC) {
					maxC = i;
				}

				if (i < minA) {
					minB = minA;
					minA = i;
				} else if (i < minB) {
					minB = i;
				}
			}

			result = Math.max(maxA * maxB * maxC, maxA * minA * minB);
		}
		return result;

	}

	@Test
	public void testHighestProduct() {
		int[] input = { 0, 2, 3, 8 };
		Assert.assertEquals(48, highestProductWithoutSort(input));

		int[] newinput = { -10, -20, 1, 2, 3, 8 };
		Assert.assertEquals(1600, highestProductWithoutSort(newinput));

		int[] newinput2 = { -1, -2, 1, 2, 3, 8 };
		Assert.assertEquals(48, highestProductWithoutSort(newinput2));

	}

	@Test
	public void testHighestProductwithoutSort() {
		int[] input = { 0, 2, 3, 8 };
		Assert.assertEquals(48, highestProduct(input));

		int[] newinput = { -10, -20, 1, 2, 3, 8 };
		Assert.assertEquals(1600, highestProduct(newinput));

		int[] newinput2 = { -1, -2, 1, 2, 3, 8 };
		Assert.assertEquals(48, highestProduct(newinput2));
	}

	@Test
	public void testCombinations() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);

		List<List<Integer>> results = combinations(32, list);
		results.stream().forEach(l -> {
			System.out.println(l);
		});
	}

	/**
	 * Given an array of size n, the array contains numbers in range from 0 to
	 * k-1 where k is a positive integer and k <= n. Find the maximum repeating
	 * number in this array. For example, let k be 10 the given array be arr[] =
	 * {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number
	 * would be 2. 
	 * Expected time complexity is O(n) and extra space allowed is
	 * O(1). Modifications to array are allowed.
	 * 
	 * @param input
	 * @return
	 */
	static int popularElement(int[] input, int maximumAllowed) {
		int[] counter = new int[maximumAllowed];
		for(int i=0; i<maximumAllowed; i++){
			counter[i] = 0;
		}

		for (int i : input) {
			counter[i] = counter[i]+1;
		}
		
		int poopularElementIndex = -1; 
		int popularElementCount = -1;
		for(int i=0; i<counter.length; i++){
			if(counter[i]>popularElementCount){
				popularElementCount = counter[i];
				poopularElementIndex = i;
			}
		}
		
		return poopularElementIndex;
		
	}
	
	// Returns maximum repeating element in input[0..n-1].
    // The array elements are in range from 0 to k-1
//	in this make sure k<n
    static int maxRepeating(int[] input, int k)
    {
        // Iterate though input array, for every element
        // input[i], increment input[input[i]%k] by k
        for (int i = 0; i< input.length; i++){
//        	System.out.println(input[i]%k);
        	int indexToIncrease = input[i];
        	input[indexToIncrease] = input[indexToIncrease] + k; 
        }
        // Find index of the maximum repeating element
        int max = input[0], result = 0;
        for (int i = 1; i < input.length; i++)
        {
            if (input[i] > max)
            {
                max = input[i];
                result = i;
            }
        }
 
        /* Uncomment this code to get the original array back
        for (int i = 0; i< input.length; i++)
          input[i] = input[i]%k; */
 
        // Return index of the maximum element
        return result;
    }
	
	@Test
	public void testPopularElement(){
		int[] input = {1,2,1,1,3,4,3,7,8,5,6,7,1,2,3,5,0,7,7,7,9,2,1,1,1,4,5,6};

		Assert.assertEquals(1, popularElement(input, 10));
		
		int[] input2 = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
		
		Assert.assertEquals(2, popularElement(input2, 10));

	}
	
	@Test
	public void testMaxRepeating(){
		int[] input = {1,2,1,1,3,4,3,7,8,5,6,7,1,2,3,5,0,7,7,7,9,2,1,1,1,4,5,6};

		Assert.assertEquals(1, maxRepeating(input, 10));
		
		int[] input2 = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
		
		Assert.assertEquals(2, maxRepeating(input2, 10));
		
		System.err.println(0%10);
		System.err.println(1%10);
		System.err.println(2%10);
		System.err.println(3%10);
		System.err.println(4%10);
		System.err.println(5%10);
		System.err.println(6%10);
		System.err.println(7%10);
		System.err.println(8%10);
		System.err.println(9%10);


	}
}
