package com.abhi.example;

import java.util.HashSet;
import java.util.Set;

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
		String[] strArr = { "civic", "ivicc", "civil", "livci", "a", "aa", "aabb", "zszsxdxdcf" };
		for(String str:strArr){
			System.out.println(str+":"+findPalindrome(str));
		}
	}
	
	public static boolean findPalindrome(String string){
		int length = string.length();
		if(length == 0 || length == 1){
			return true;
		}
		char[] chars = string.toCharArray();
		int remainder  = length%2;
		
		Set<Character> set = new HashSet<Character>();
		for(char singChar: chars){
			set.add(singChar);
		}
		int size = set.size();
		if(size <= (Math.abs(length/2)+remainder)){
			return true;
		}
		return false;
	}

}
