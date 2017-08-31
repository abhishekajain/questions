package com.abhi.algo;

/**
 * 
 * @author abhishek.ajain
 *
 */
public class ReverseString {
	
	public static void main(String[] args){
		System.out.println(reverse("Strings in Java are immutable"));
		System.out.println(reverse("this is a test!"));
	}
	
	public static String reverse(String str){
		char[] chars = str.toCharArray();
		int start = 0;
		int last = chars.length-1;
		int remainder = chars.length%2;
		while((last-start)!=(1+remainder))
			swap(chars, start++, last--);
		return new String(chars);
		
	}
	
	public static void swap(char[] chars, int start, int last){
		char first = chars[start];
		char end = chars[last];
		chars[start] = end;
		chars[last] = first;		
	}
}
