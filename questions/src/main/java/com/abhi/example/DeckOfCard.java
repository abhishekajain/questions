package com.abhi.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class DeckOfCard {
	
	private static Random rand = new Random();
	
	public static void shuffledDeck(Stack<Integer> deck){
		//random number between 1 - 51
		int n = rand.nextInt(deck.size()) + 1;
		Stack<Integer> half1 = new Stack<Integer>();
		Stack<Integer> half2 = new Stack<Integer>();
		for(int i=0; i<n; i++){
			half1.push(deck.pop());
		}
		while (!deck.isEmpty()) {			
			half2.push(deck.pop());
		}
	
		
	}
	
	public static void main(String[] args){
		List<Integer> list = Arrays.asList(1,2,3);
		
		String e = ""+2+1+1+1;
		System.err.println(e);
		int a = (int) Math.pow(Integer.parseInt(e), begin(0));
		System.out.println(a);
		new ReaderThread().start();
		ready = true;
		number = 42;
	}
	
	
	public static int begin(int in){
		if(in >=3){
			return begin(1);
		}else if(in >=2){
			return 2;
		}else if(in >=1){
			return 1;
		}
		return 0;
	}
	private static int number;
	private static boolean ready;
	public static class ReaderThread extends Thread{
		public void run() {
			while (!ready) {
				Thread.yield();				
			}
			System.out.println(number);
			// TODO Auto-generated method stub

		}
	}
		

}
