package com.abhi.datastructure;

/**
 * 
 * @author abhishek.ajain
 *
 */

public class TwoEgg {
	
	public static void main(String[] args){
		int[] floors = new int[99];
		for(int index=0; index<floors.length; index++){
			floors[index] = index+1;
		}
		System.out.println("Found Element " +98+" at index:"+binarySearch(floors, 98));
		
		System.out.println(solveSeries(100));
		
		System.out.println("Found Element " +98+" at index:"+indexSearch(floors, 98, (int)Math.round(solveSeries(100))));


		
	}
	//not a best case
	public static int binarySearch(int[] floors, int element){
		int min = 0;
		int max = floors.length-1;
		int average = 0;
		boolean findIt = false;
		while(min<=max){
			average = (min+max)/2;
			if(floors[average]<element){
				min = average+1;
			}else if(floors[average]>element){
				max = average-1;
			}else{
				System.out.println(average+":"+floors[average]);
				findIt = true;
				break;
			}
		}
		
		if(!findIt){
			System.out.println("Didnt find element in the array:"+element);
			return -1;
		}
		
		return average;
	}
	
	public static int indexSearch(int[] floors, int element, int index){
		boolean findIt = false;
		int safeIndex = 0;
		int counter = index;
		index--;
		while(index<=floors.length){
			if(element<floors[index]){
				while(safeIndex<index){
					safeIndex++;
					if(element == floors[safeIndex]){
						index = safeIndex;
						break;
					}
				}
			}else if(element>floors[index]){
				safeIndex = index;
				counter--;
				index = index + counter;
			}else {
				System.out.println(index+":"+floors[index]);
				findIt = true;
				break;
			}
		}
		
		if(!findIt){
			System.out.println("Didnt find element in the array:"+element);
			return -1;
		}
		
		return index;
	}
	//x+(x-1)+(x-2)+(x-3)+....+1=sum
	//a1, a2, a3, ...., an series sum
	//sum = n*(a1+an)/2
	//in above case n=x an=1 a1=x
	//sum = x(x+1)/2
	public static double solveSeries(int sum){
		//2*sum = x*x+x
		//x*x+x-2*sum=0
		//ax*x+bx+c=0
		//(-b+^(b*b-4ac))/2a
		//a=1, b=1, c=-2*sum
		return (-1+Math.pow((1-4*1*-2*sum), 0.5))/2;
	}
	
}
