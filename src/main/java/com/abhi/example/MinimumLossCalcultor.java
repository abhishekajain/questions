package com.abhi.example;

import java.util.Scanner;

/**
 * Lauren has a chart of distinct projected prices for a house over the next
 * years, where the price of the house in the year is . She wants to purchase
 * and resell the house at a minimal loss according to the following rules:
 * 
 * The house cannot be sold at a price greater than or equal to the price it was
 * purchased at (i.e., it must be resold at a loss). The house cannot be resold
 * within the same year it was purchased. Find and print the minimum amount of
 * money Lauren must lose if she buys the house and resells it within the next
 * years.
 * 
 * Note: It's guaranteed that a valid answer exists.
 * 
 * Input Format
 * 
 * The first line contains an integer, , denoting the number of years of house
 * data. The second line contains space-separated long integers describing the
 * respective values of .
 * 
 * Constraints
 * 
 * All the prices are distinct. It's guaranteed that a valid answer exists.
 * 
 * Input Format
 * 
 * The first line contains an integer, n, denoting the number of years of house
 * data. The second line contains space-separated long integers describing the
 * respective values of p1,p2,...,pn .
 * 
 * 3
 * 5 10 3
 * ans 2
 * 
 * 5
 * 20 7 8 2 5
 * ans 2
 * @author abhishek.ajain
 *
 */
public class MinimumLossCalcultor {
	
	   public static void main(String[] args) {
	    	Scanner in = null;
	    	try{
		    	in = new Scanner(System.in);    
		    	String line = null;
		    	int count = 0;
		    	int year = 0;
		    	String value = null;
		    	//this will block the scanner and will not timeout if input is not given...
		    	while(count <=1 && in.hasNextLine()){
		    		line = in.nextLine();
		    		if(count ==0)
		    			year = Integer.parseInt(line);
		    		if(count ==1)
		    			value = line;
		    		count++;
		    	}
		    	String[] values = value.split(" ");
		        long[] longValues = new long[values.length];
		        for(int i=0; i<values.length; i++){
		            longValues[i] = new Long(values[i]);
		        }
		    	System.out.println((minimumLoss(new Integer(year), longValues))*-1l);
	    	}finally {
	    		if(in != null)
	    			in.close();
			}
	    }
	    
	    public static long minimumLoss(int years, long[] prizes){
	    	long loss = Long.MIN_VALUE;
	    	for(int i=0; i<years; i++){
	    		long temp = loss(years, i, prizes);
	    		if(temp<0 && loss<temp){
	    			loss = temp;
	    		}
	    	}
	    	return loss;
	    }
	    
	    private static long loss(int years, int index, long[] prizes){
	    	long loss = Long.MIN_VALUE;
	    	for(int i=index+1; i<years; i++){
	    		long temp = prizes[i] - prizes[index];
	    		if(temp<0 && loss<temp){
	    			loss = temp;
	    		}
	    	}
	    	return loss;
	    }

}
