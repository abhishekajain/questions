package com.abhi.datastructure.arrary;

public class SortAndMergeArray {

	public static int[] array1 = { 1, 3, 7, 9, 0, 0, 0 };
	public static int[] arr1 = { 1, 3, 7, 9, 12, 14, 0, 0, 0, 0, 0, 0 };

	public static int[] arr2 = { 2, 4, 8, 10, 11, 15};

	public static void main(String args[]) {
		
		int totalArrLength = arr1.length - arr2.length;
		for (int j = 0; j < arr2.length; j++) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] > arr2[j]) {
					moveElements(arr1, totalArrLength + j, i, arr2[j]);
					arr2[j]=0;
					break;
				}
			}
		}
		
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+",");
		System.out.println();
		
		for(int i=0;i<arr2.length;i++)
			System.out.print(arr2[i]+",");
		System.out.println();
		
		for (int j = 0; j < arr2.length; j++) {
			if(arr2[j] != 0) {
				for(int i=0;i < arr1.length; i++) {
					if(arr1[i] == 0) {
						arr1[i] = arr2[j];
						break;
					}
				}
				arr2[j] = 0;
			}
		}
		

		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+",");
		System.out.println();
		
	}

	private static void moveElements(int[] arr, int startelement, int endelement, int swappedelement) {
		System.out.println(
				"startelement:" + startelement + "endelement:" + endelement + "swappedelement:" + swappedelement);
		for (int k = startelement; k >= endelement; k--) {
			arr[k] = arr[k - 1];
		}
		arr[endelement] = swappedelement;
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+",");
		
		System.out.println();
	}

}
