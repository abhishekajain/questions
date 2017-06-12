package com.abhi.datastructure;

/**
 * Since strings in Java are immutable, first convert the string into an array
 * of characters, do the in-place reversal on that array, and re-join that array
 * into a string before returning it. This isn't technically "in-place" and the
 * array of characters will cost O(n)O(n) additional space, but it's a
 * reasonable way to stay within the spirit of the challenge. If you're
 * comfortable coding in a language with mutable strings, that'd be even better!
 * 
 * @author abhishek.ajain
 *
 */
public class ReverseString {
	
	public static void main(String[] args){
		System.out.println(reverse("Since strings in Java are immutable"));
		System.out.println(reverse("this is a demo test!"));
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
