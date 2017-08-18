package com.abhi.example;

import java.util.Stack;

/**
 * 
 * noun: palindrome; plural noun: palindromes a word, phrase, or sequence that
 * reads the same backward as forward, e.g., madam or nurses run.
 * 
 * @author abhishek.ajain
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		String[] strArr = {"aa", "civic", "ivicc", "civil", "livci", "a", "aa", "aabb", "zszsxdxdcf", "abba" };
		for(String str:strArr){
			System.out.println(str+":"+findPalindrome(str));
		}
	}
	
	public static boolean findPalindrome(String string){
		int length = string.length();
		if(length == 0 || length == 1){
			return true;
		}
		int half  = length/2;
		int remainder = length%2;

		String firstHalf = string.substring(0, half);
		String secondHalf =string.substring(half+remainder);
//		System.err.println(firstHalf+firstHalf.hashCode());
//		System.err.println(secondHalf+secondHalf.hashCode());

//		if(firstHalf.hashCode() == secondHalf.hashCode()){
			Stack<Character> stack = new Stack<Character>();
			secondHalf.chars().forEach(c ->{
				stack.push(new Character((char)c));
			});
			String str = "";
			while (!stack.isEmpty()) {
				str = str+stack.pop();			
			}
			if(firstHalf.equals(str)){
				return true;
			}
//		}
		
		return false;
	}

}
