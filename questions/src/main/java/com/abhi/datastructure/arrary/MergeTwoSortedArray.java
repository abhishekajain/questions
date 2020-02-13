package com.abhi.datastructure.arrary;

public class MergeTwoSortedArray {
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {2,4,8,9,10};
//		print(merge(a,b));
		
		int[] nums1 = {1,2,4,5,6,0};
		int[] nums2 = {3};
		merge(nums1, 5, nums2, 1);
		
		int[] nums11 = {1,2,3,0,0,0};
		int[] nums22 = {2,5,6};
		merge(nums11, 3, nums22, 3);
		
		int[] nums111 = {0};
		int[] nums222 = {1};
		merge(nums111, 0, nums222, 1);
		
		int[] nums1111 = {1,0};
		int[] nums2222 = {2};
		merge(nums1111, 1, nums2222, 1);
		
		int[] nums11111 = {-1,0,0,0,3,0,0,0,0,0,0};
		int[] nums22222 = {-1,-1,0,0,1,2};
		merge(nums11111, 5, nums22222, 6);

	}
	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		
		int ai = 0;
		int bi = 0;
		int i = 0;
		while(ai<a.length || bi<b.length) {
			if(ai==a.length) {
				c[i++]=b[bi++];
				continue;
			}else if(bi==b.length) {
				c[i++]=a[ai++];
				continue;
			}
			
			if(a[ai]<b[bi]) {
				c[i++]=a[ai++];
			}else  {
				c[i++]=b[bi++];
			}
		}
		return c;
	}
	public static void print(int[] a) {
		System.out.println("{");
		for(Integer i:a) {
			System.out.print(i+",");
		}
		System.out.println("}");
	}
	
	
//	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//	Note:
//
//	The number of elements initialized in nums1 and nums2 are m and n respectively.
//	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//	Example:
//
//	Input:
//	nums1 = [1,2,3,0,0,0], m = 3
//	nums2 = [2,5,6],       n = 3
//
//	Output: [1,2,2,3,5,6]
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        
        if(m==0) {
            for(int i=0;i<n;i++) {
                nums1[i]=nums2[i];
            }
        	print(nums1);

            return;
        }
        
        int mi=0;
    	int ni=0;
    	int totalElement = m+n;
    	
    	for(int i=0;i<totalElement;i++) {
    		if(ni==n) {
    			break;
    		} else if(mi>=m+ni && nums1[mi] == 0) {
    			nums1[mi++]=nums2[ni++];
    		} else if(nums1[mi]>nums2[ni]) {
                for(int j=totalElement-1; j>mi ;j--) {
                		nums1[j]=nums1[j-1];    	
    	        }
    			nums1[mi++]=nums2[ni++];
    		}else {
    			mi++;
    		}
    	}
    	
    	print(nums1);
    }
    
    public static void moveOnePosition(int[] nums1, int mi, int totalElement) {
    	for(int j=totalElement; j>mi ;j--) {
    		nums1[j-1]=nums1[j-2];    	
    	}
    }
    
    public void mergeBestSolution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];                
            } else {
                nums1[k] = nums2[j--];                
            }
        }        
    }

}
