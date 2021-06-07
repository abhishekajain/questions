package com.abhi.example;

/**
 * the best profit I could have made from 1 purchase and 1 sale of 1 stock yesterday
 * 
 * @author abhishek.ajain
 *
 */

public class BestProfit {
	public static void main(String[] args) {
		int[] stockPricesYesterday = new int[] { 10, 7, 5, 8, 11, 2, 5, 9 };

		System.out.println("Max Profit >>>"+getMaxProfit(stockPricesYesterday));
	}

	public static int getMaxProfit(int[] stockPricesYesterday) {
		int maxProfit = 0;
		for(int i=0; i<stockPricesYesterday.length; i++){
			int stockPrize = stockPricesYesterday[i];
			int profit = getProfit(stockPricesYesterday, i, stockPrize);
			System.out.println("stockPricesYesterday>>"+stockPrize+"<<profit>>"+profit);
			if(profit > maxProfit){
				maxProfit = profit;
			}
		}
		return maxProfit;
	}
	
	public static int getProfit(int[] stockPricesYesterday, int index, int stockPrize){
		int profit = 0;
		for(int i=index; i<stockPricesYesterday.length; i++){
			int diff = stockPricesYesterday[i] - stockPrize;
			if(diff > profit){
				profit = diff;
			}
		}
		return profit;
	}
}
