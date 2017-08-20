package com.abhi.datastructure;

/**
 * A building has 100 floors. One of the floors is the highest floor an egg can
 * be dropped from without breaking. If an egg is dropped from above that floor,
 * it will break. If it is dropped from that floor or below, it will be
 * completely undamaged and you can drop the egg again.
 * 
 * Given two eggs, find the highest floor an egg can be dropped from without
 * breaking, with as few drops as possible.
 * 
 * We can do better than a binary approach, which would have a worst case of 50 drops.
 * 
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
		int element = 3;
		System.out.println("Found Element " +element+" at index:"+binarySearch(floors, element));
		
		System.out.println(solveSeries(100));
		
	}
	
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
