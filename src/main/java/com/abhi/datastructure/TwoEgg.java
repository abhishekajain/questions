package com.abhi.datastructure;

import com.sun.org.apache.regexp.internal.REUtil;

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
		
		System.out.println(findIndex(floors, 67));
		
	}
	
	public static int findIndex(int[] floors, int element){
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
		
		return average;
	}
	
}