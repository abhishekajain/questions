package com.abhi.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoDimensionArray {
	
	public static void main(String[] args){
		int[][] input = {
				{1,2,3},
				{2,3,1},
				{3,1,2}
		};
		String[] inputStr = {"a","b","c","d"};
		List<String> inputList = Arrays.asList(inputStr);
		System.out.println("0>>>"+inputList);
		for(int i=0; i<inputStr.length-1; i++){
			//System.out.println("1>>>"+inputList);
			Collections.swap(inputList, i, inputStr.length-1);
			System.out.println("2>>>"+inputList);
		}
	}

}
