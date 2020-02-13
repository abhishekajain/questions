package com.abhi.datastructure.arrary;

import java.util.Random;

import org.junit.Test;

public class ArrayTracker {
	
	//0-110
	private int[] countHoldingArray = new int[111];
	
	private int max = Integer.MIN_VALUE;
	private int min = Integer.MAX_VALUE;
	private long sum = 0;
	private long count = 0;
	
	int left = Integer.MIN_VALUE;
	int right = Integer.MAX_VALUE;
	int median = -1;
	
	public void insert(int input){
		this.countHoldingArray[input] = this.countHoldingArray[input] + 1;
		
		if(this.max<input){
			this.max = input;
		}		
		
		if(this.min>input){
			this.min = input;
		}
		this.sum = this.sum + input;
		this.count++;
		
		if(median == -1){ 
			median = input;
		}else if(input<left){
			right = median;
			median = left;
			left = input;
		} else if(input>right){
			left = median;
			median = right;
			right = input;			
		} else if(input>left && input<median){
			left = input;
		} else if(input>median && input<right) {
			right = input;
		} 
	}
	
	public int getMax(){
		return this.max;
	}
	
	public int  getMin(){
		return this.min;
	}
	
	public double getMean(){
		return this.sum/this.count;
	}
	//middle element
	public int getMedian(){
		return median;
	}
	
	//most popular element
	public int getMode(){
		int maxCount=0;
		int mode = -1;
		for(int i=0; i<countHoldingArray.length;i++){
			if(countHoldingArray[i]>maxCount){
				maxCount = countHoldingArray[i];
				mode = i;
			}
		}
		return mode;
	}
	
	@Test
	public void testMode(){
		ArrayTracker tracker = new ArrayTracker();
		
		Random random = new Random();
		int count = 0;
		while(count<200){
			int input = random.nextInt(110);
			System.out.println("-----------------");
			System.out.println("input-->"+input);
			tracker.insert(input);
			System.out.println("mod-->"+tracker.getMode());
			System.out.println("getMin-->"+tracker.getMin());
			System.out.println("getMean-->"+tracker.getMean());
			System.out.println("getMax-->"+tracker.getMax());

			count++;
		}
	
	}

}
