package com.abhi.algo;

import java.util.HashMap;
import java.util.Map;

public class RuleEngine {
	
	static class Rule{
		String ruleKey;
		String ruleDescription;
	}
	
	static Map<String, String> createIndex(Rule[] categoryX, Rule[] categoryY, Rule[] categoryZ){
		
		Map<String, String> indexResult = new HashMap<String, String>();
		
		for(int x=0; x<categoryX.length; x++){
			for(int y=0; y<categoryY.length; y++){
				for(int z=0; z<categoryZ.length; z++){
//					indexResult.put(categoryX[x]+categoryY[y]+categoryZ[z],)
					System.out.println(categoryX[x].ruleKey+categoryY[y].ruleKey+categoryZ[z].ruleKey);
				}
			}
		}
		return indexResult;
		
	}
	
	static void createIndex(String[] categoryX, String[] categoryY, String[] categoryZ){
		for(int x=0; x<categoryX.length; x++){
			for(int y=0; y<categoryY.length; y++){
				for(int z=0; z<categoryZ.length; z++){
					System.out.println(categoryX[x]+categoryY[y]+categoryZ[z]);
				}
			}
		}
		
	}
	
//	static String[][] createUniquePremutation(String[] categoryX, int times){
//		String[][] result = new String[20][3];
//		int item = 0;
//		int timesNew = 0;
//		for(int x=0; x<categoryX.length; x++){//1
//			timesNew++;//1
//			if(timesNew == times){
//				
//			}
//			for(int y=x+1; y<categoryX.length; y++){//2
//				timesNew++;//2
//				if(timesNew == times){
//					
//				}
//				dummynn(categoryX, x, item, result, times, timesNew, );
//				for(int z=y+1; z<categoryX.length; z++){//3
//					timesNew++;//3
//					if(timesNew == times){
//						String[] value = {categoryX[x], categoryX[y], categoryX[z]};						
//						dummym(item, value, result);
//						item++;
//					}
//
//				}
//			}
//		}	
//		return result;
//	}
	static String[][] createUniquePremutation(String[] categoryX, int times){
		String[][] result = new String[NCX(categoryX.length, times)][times];
		dummynn(categoryX, -1, 0, result, times, 0, new String[times]);
		return result;

	}
	
	static void dummynn(String[] categoryX, int forCounter, int item, String[][] result, int times, int timesNew, String[] valueOld){
		for(int z=forCounter+1; z<categoryX.length; z++){//3
			String[] value = valueOld.clone();
			if(timesNew == (times-1)){
				value[timesNew] = categoryX[z];
				dummym(item, value, result);
				item++;
				if(item == (categoryX.length-1)){
					timesNew = 0;
				}
			}else{				
				value[timesNew] = categoryX[z];
				dummynn(categoryX, z, item, result, times, timesNew, value);
				timesNew++;//3
			}

		}
	}
	
	public static int NCX(int N, int X) {
		int factorialN = factorial(N);
		int factorialX = factorial(X);
		int factorialSubtraction = factorial(N-X);
		int result = factorialN / (factorialX*factorialSubtraction);
		return result;
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int fact = 1; // this will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
	static void dummym(int item, String[] value, String[][] input){
		input[item] = value;
		System.out.println("");
		for(String str: value){
			System.out.print(str);
		}
	}
	
	public static void main(String[] args){
		String[] categoryX = {"X1", "X2", "X3", "X4", "X5", "X6"};
		String[] categoryY = {"Y1", "Y2", "Y3"};
		String[] categoryZ = {"Z1", "Z2", "Z3"};
		
//		createIndex(categoryX, categoryY, categoryZ);
		createUniquePremutation(categoryX, 3);


	}

}
