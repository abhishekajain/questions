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
        	int indexToIncrease = input[i]%k;
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
 
        /* Uncomment this code to get the original array back*/
        for (int i = 0; i< input.length; i++)
          input[i] = input[i]%k; 
 
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
	
//	Longest Increasing Subsequence
//	Find the longest increasing subsequence of a given sequence / array.
//
//	In other words, find a subsequence of array in which the subsequences elements are in strictly increasing order, and in which the subsequence is as long as possible.
//	This subsequence is not necessarily contiguous, or unique.
//	In this case, we only care about the length of the longest increasing subsequence.
//
//	Example :
//
//	Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
//	Output : 6
//	The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
	public static int longestIncreasingSequence(int[] input){
		if(input == null || input.length == 0){
			return 0;
		}
		if(input.length == 1){
			return 1;
		}
		int[][] seq = null;
		for(int i=input.length-1;i>=0;i--){
			seq = createMaxSeq(seq ,input[i]);
		}
		
		int maxLength = 0;
		System.out.println(seq);
		for(int index = 0 ; index<seq.length; index++){
			if(seq[index].length>maxLength){
				maxLength = seq[index].length;
			}
		}
		return maxLength;
	}
	
	public static int longestIncreasingSequence(final List<Integer> a){
		int[] input = new int[a.size()];
		for(int i = 0 ; i<a.size(); i++){
			input[i] = a.get(i);
		}
		return longestIncreasingSequence(input);
	}
	
	@Test
	public void testLongestIncreasingSequence(){
		int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		Assert.assertEquals(6, longestIncreasingSequence(input));
		
		int[] input2 = { 69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 
				94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 
				50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 };
	
		Assert.assertEquals(15, longestIncreasingSequence(input2));

	}
	private static int[][] createMaxSeq(int[][] input, int element){
		if(input == null){
			input = new int [1][1];
			int[] seq = new int[1];
			seq[0] = element;
			input[0] = seq;
			return input;
		}
		List<List<Integer>> newSeqs = new ArrayList<List<Integer>>();
		for(int j=0; j<input.length;j++){
			if(element<input[j][0]){
				List<Integer> seq = new ArrayList<Integer>();	
				seq.add(element);
				for(int i=0; i<input[j].length;i++){
					seq.add(input[j][i]);
				}
				newSeqs.add(seq);
			}				
		}

		for(int j=0; j<input.length;j++){
			List<Integer> seq = new ArrayList<Integer>();	
			for(int i=0; i<input[j].length;i++){
				seq.add(input[j][i]);
			}
			newSeqs.add(seq);
		}
	
		List<Integer> seq = new ArrayList<Integer>();	
		seq.add(element);
		newSeqs.add(seq);
		
		int[][] result = new int[newSeqs.size()][];
		int count = 0;
		for(List<Integer> seq1: newSeqs){
			int[] intSeq = new int[seq1.size()];
			result[count] = intSeq;
			int newCount = 0;
			for(Integer i:seq1){
				intSeq[newCount] = i;
				newCount++;
			}
			count++;
		}
		
		return result;
	}
	
	/* Standard Binary Search function */
//	return index of the key
	// low index to start
	// high index to end/
	// it is sorted array
	static int binarySearch(int arr[], int low, int high, int key) {
		if(low>high){
			return -1;
		}
		int middle = (low+high)/2;
		
		if(arr[middle] == key){
			return middle;
		} else if(key>arr[middle]){
			return binarySearch(arr, middle+1, high, key);
		} else{
			return binarySearch(arr, low, middle-1, key);
		}
	}
	
	/*
	 * Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns 3 (index of
	 * 6)
	 */
	static int findPivot(int arr[], int low, int high) {
		if(low>high){
			return -1;
		}
		if(low == high){
			return low;
		}
		
		int middle = (low+high)/2;
		
		//check if found pivot first
		if(arr[middle] > arr[middle+1]){// if middle is greater then next element it is pivot since it is sorted list
			// and next element should be higher if it is before or
			return middle;
		} else if( arr[middle] < arr[middle-1]){
			return middle-1;
		} 
		
		if (arr[low] >= arr[middle])//if low value is greater then middle search pivot on lower side                 
			return findPivot(arr, low, middle - 1);
		return findPivot(arr, middle + 1, high);

	}	
	
	static int getNonZeroLenght(int[] input){
		int zeroCount = getZeroCount(input);
		
		int nonZeroLength = input.length - zeroCount;
		if(nonZeroLength >0){
			swapZeros(input, zeroCount);
		}		
		return nonZeroLength;		
	}
	
	static int getZeroCount(int[] input){
		int zeroCount = 0;
		for(int element:input){
			if(element == 0){
				zeroCount++;
			}
		}
		return zeroCount;
	}
	
	static void swapZeros(int[] input, int zeroCount){
		int inputLength = input.length;
		int nonZeroLength = inputLength - zeroCount;
		
		for(int i=0; i<nonZeroLength; i++){			
			if(inputLength <= nonZeroLength){
				break;
			}
			
			int element = input[i];
			if(element == 0){
				int temp = 0;
				while(temp == 0){
					temp = input[--inputLength];
					input[inputLength] = 0;
				}
				input[i] = temp;
			}
		}
	}
	
	@Test
	public void testgetNonZeroLenght(){
		System.out.println("testgetNonZeroLenght-->");

		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		Assert.assertEquals(9, getNonZeroLenght(arr1));
		
		int arr2[] = { 0, 6, 7, 0, 9, 0, 1, 2, 3 };
		Assert.assertEquals(6, getNonZeroLenght(arr2));
		
		int arr3[] = { 0, 0, 0, 0, 9, 10, 1, 2, 3 };
		Assert.assertEquals(5, getNonZeroLenght(arr3));
		
		int arr4[] = { 1, 4, 5, 0, 0, 0, 0, 0, 0 };
		Assert.assertEquals(3, getNonZeroLenght(arr4));
		
		
		int arr5[] = { 0, 4, 5, 1, 0, 0, 0, 0, 0 };
		Assert.assertEquals(3, getNonZeroLenght(arr5));
		
		System.out.println("<--testgetNonZeroLenght");
	}
//	/*
//	 * Searches an element key in a pivoted sorted array arrp[] of size n
//	 */
//	static int pivotedBinarySearch(int arr[], int n, int key) {
//
//	}
	
	@Test
	public void testpivotedBinarySearch() {
		// Let us search 3 in below array
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int n = arr1.length;
		int key = 3;
		System.out.println("Index of the element is: " + findPivot(arr1, 0, arr1.length-1));
		
		int[] arr2 = {3, 4, 5, 6, 1, 2};
		System.out.println("Index of the element is: " + findPivot(arr2, 0, arr2.length-1));
		
		
		int[] arr3 = {6, 1, 2, 3, 4, 5};
		System.out.println("Index of the element is arr3: " + findPivot(arr3, 0, arr3.length-1));
		
		int[] arr4 = {3, 4, 5, 6, 7, 1};
		System.out.println("Index of the element is arr3: " + findPivot(arr4, 0, arr4.length-1));
	}
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> holder = new ArrayList<ArrayList<Integer>>();
		int maxSum = 0;
		int counter = 0;
		for(Integer element:a){
			if(element>=0){
				
			}else{
				
			}
		}
		return list;
	
	}
	
	 // Function which pushes all zeros to end of an array.
    public static int pushZerosToEnd(int[] arr) {
    	int count = 0;//count of non zero elements
    	int length = arr.length;// length of array
    	for(int i=0;i<length;i++){//full length scan of array O(n)
    		if(arr[i] !=0){
    			arr[count++] = arr[i];//move to front and increase count of non zero element
    		}
    	}
    	int countOfNonZero = count;//count of non zero elements

    	while(count<length){ //O(n-countOfNonZero)
    		arr[count++] = 0;
    	}
    	return countOfNonZero;//O(2N-countOfNonZero)
    }
    
	@Test
	public void testpushZerosToEnd(){
		System.out.println("testpushZerosToEnd-->");

		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		Assert.assertEquals(9, pushZerosToEnd(arr1));
		
		int arr2[] = { 0, 6, 7, 0, 9, 0, 1, 2, 3 };
		Assert.assertEquals(6, pushZerosToEnd(arr2));
		
		int arr3[] = { 0, 0, 0, 0, 9, 10, 1, 2, 3 };
		Assert.assertEquals(5, pushZerosToEnd(arr3));
		
		int arr4[] = { 1, 4, 5, 0, 0, 0, 0, 0, 0 };
		Assert.assertEquals(3, pushZerosToEnd(arr4));
		
		
		int arr5[] = { 0, 4, 5, 1, 0, 0, 0, 0, 0 };
		Assert.assertEquals(3, pushZerosToEnd(arr5));
		
		System.out.println("<--testpushZerosToEnd");
	}
	
//	i-3<i-2<i-1<i>i+1>i+2>i+3
    public static int peakIndexInMountainArray(int[] A) {
    	int length = A.length;
    	if(length<3) {
    		return -1;
    	}
        int L = 0;
        int R = length -1;
    	while(L<=R) {
            int m = (L+R)/2;
	        if(A[m-1]<A[m] && A[m]>A[m+1]) {
	        	return m;
	        }else if(A[m] > A[m+1]) {
	        	R = m;
	        }else if(A[m]>A[m-1]){
	        	L = m;        	
	        }else {
	        	return -1;
	        }
    	}
        return -1;
    }
    
    static class MountainArray{
    	int[] A;
    	
    	public MountainArray(int[] A) {
    		this.A = A;
    	}
    	
    	public int length() {
    		return A.length;
    	}
    	
    	public int get(int index) {
    		return A[index];
    	}
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        if(length <3) {
            return -1;
        }
           
        int L = 0;
        int R = length -1;
        int peakIndex = -1;
        while(L<=R){
            int m = (L+R)/2;
            int middleVal = mountainArr.get(m);
            int leftVal = mountainArr.get(m-1);
            int rightVal = mountainArr.get(m+1);
            if(leftVal<middleVal && rightVal<mountainArr.get(m)){
                peakIndex = m;
                break;
            }else if(middleVal > rightVal){
                R = m;
            }else if(middleVal > leftVal){
                L = m;
            }else{
                return -1;
            }
        }
        if(peakIndex == -1){
            return -1;
        }
        System.out.println(peakIndex);
        L=0;
        R=peakIndex;
        while(L<=R){
            int m = (L+R)/2;
            int middleVal = mountainArr.get(m);
            if(middleVal > target){
                R = m-1;
            }else if(middleVal<target){
                L = m+1;
            }else{
                return m;
            }
        }
        
        L=peakIndex;
        R=length -1;
        while(L<=R){
            int m = (L+R)/2;
            int middleVal = mountainArr.get(m);
            if(middleVal > target){
                L = m+1;
            }else if(middleVal<target){
                R = m-1;
            }else{
                return m;
            }
        }        
        
        return -1;
    }
    
    public int findInMountainArray1(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int maximal = findMaximal(mountainArr);
        int idx = binarySearch(mountainArr, 0, maximal, true, target);
        if (idx >= 0) return idx;
        return binarySearch(mountainArr, maximal, n - 1, false, target);
    }
    
    private int findMaximal(MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 1;
        int right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean leftAsc = mountainArr.get(mid-1) < mountainArr.get(mid);
            boolean rightDesc = mountainArr.get(mid) > mountainArr.get(mid+1);
            if (leftAsc && rightDesc) return mid;
            if (leftAsc) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
    
    private int binarySearch(MountainArray mountainArr, int left, int right, boolean asc, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);
            if (val == target) return mid;
            
            boolean lt = val < target;
            if (asc == lt) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }    
    
    @Test
    public void testFindInMountainArray() {
    	System.out.println("testFindInMountainArray-->");
    	int[] A = {0,1,2,4,2,1};
    	MountainArray arr = new MountainArray(A);
    	System.out.println(findInMountainArray(3, arr));
    }
    
    @Test
	public void testPeakIndexInMountainArray() {
    	int[] A = {18,29,38,59,98,100,99,98,90};
    	System.out.println(A[peakIndexInMountainArray(A)]);
    }
//    asc true i-2<i-1<i<i+1<i+2 
//    asc false i-2>i-1>i>i+1>i+2
    public static int binarySearch(int[] A, boolean asc, int target, int L, int R) {
    	while(L<=R) {
    		int m = (L+R)/2;
    		if(A[m] == target) {
    			return m;
    		}else if(A[m]>target) {
    			if(asc) {
    				R=m-1;
    			}else {
    				L=m+1;
    			}
    		}else {
    			if(asc) {
    				L=m+1;
    			}else {
    				R=m-1;
    			}
    		}
    	}
    	return -1;
    }
    
    @Test
    public void testBinarySearch() {
    	System.out.println("tesBinarySearch");
    	int[] A = {18,29,38,59,98,100,99,98,90};
    	System.out.println(binarySearch(A, true, 11, 0, 5));
    	System.out.println(binarySearch(A, false, 59, 5, 8));

    }
    
    
    @Test
    public void testFactorial() {
    	System.out.println("testFactorial");
    	long n = 7;
    	long result = 1;
    	while(n>1) {
    		result = result*n;
    		n--;
    	}
    	
    	System.out.println(result);
    }
}
