package com.abhi.string;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class StringUtil {

	//print string permutation
	/**
	 * Algo {A,B,C}
	 * first take index 0 and swap with all
	 * A swap with A {A,B,C} ---> now take second char and make first char fixed {A,B,C} and {A,C,B}
	 * A swap with B {B,A,C} ---> now take second char and make first char fixed {B,A,C} and {B,C,A}
	 * A swap with C {C,B,A} ---> now take second char and make first char fixed {C,B,A} and {C,A,B}
	 * now take second char on each
	 * 
	 */
	public static void permute(String str, int startIndex, int endIndex) {
		if (startIndex == endIndex) {
			System.out.println(str);
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				str = swap(str, startIndex, i);
				permute(str, startIndex + 1, endIndex);
				str = swap(str, startIndex, i);
			}
		}
	}

	// Swap string char of position i and j
	public static String swap(String str, int i, int j) {
		char[] chars = str.toCharArray();
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
		return String.valueOf(chars);
	}

	@Test
	public void testPermute() {
		String str = new String("ABC");
		permute(str, 0, str.length() -	 1);
	}
	
	//Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
	//abcd! length 5 char 0 to 4 0123 5/2 = 2 
	public static String reverse(String str){
		int startIndex = 0;
		int endIndex = str.length()-2;//4
		
		char[] chars = str.toCharArray();
		
		while(startIndex<endIndex){
			char temp = chars[startIndex];
			chars[startIndex++] = chars[endIndex];
			chars[endIndex--] = temp;			
		}
		return String.valueOf(chars);
	}
	
	@Test
	public void testReverse(){
		Assert.assertEquals("dcba!", reverse("abcd!"));
		Assert.assertEquals("edcba!", reverse("abcde!"));
	}
	
	//abcde length 5 char 0 to 4 0123 5/2 = 2 
	public static String reverseFull(String str){
		int startIndex = 0;
		int endIndex = str.length()-1;
		
		char[] chars = str.toCharArray();
		
		while(startIndex<endIndex){
			char temp = chars[startIndex];
			chars[startIndex++] = chars[endIndex];
			chars[endIndex--] = temp;			
		}
		return String.valueOf(chars);
	}	
	
	@Test
	public void testReverseFull(){
		Assert.assertEquals("edcba", reverseFull("abcde"));
		Assert.assertEquals("fedcba", reverseFull("abcdef"));
	}
	//a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
	public static boolean anagrams(String a, String b){
		if(a == null && b == null){
			return true;
		}
		if(a == null || b == null){
			return false;
		}
		if(a.length() != b.length()){
			return false;
		}
		
		char[] charsa = a.toCharArray();
		char[] charsb = b.toCharArray();
		
		Arrays.sort(charsa);
		Arrays.sort(charsb);

		if((String.valueOf(charsa)).equals(String.valueOf(charsb))){
			return true;
		}
		return false;
	}
	
	@Test
	public void testAnagrams(){
		Assert.assertTrue(anagrams("cinema", "iceman"));
		Assert.assertTrue(anagrams("cinemaaec", "iceaecman"));

	}
	
	public static boolean isPalindrome(String str){
		if(str == null || str.length() == 1){
			return true;
		}
		int startIndex = 0;
		int endIndex = str.length()-1;
		char[] chars = str.toCharArray();
		
		while(startIndex<endIndex){
			if(chars[startIndex++] != chars[endIndex--]){
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testIsPalindrome(){
		Assert.assertTrue(isPalindrome("abba"));
		Assert.assertTrue(isPalindrome("abbccbba"));
		Assert.assertFalse(isPalindrome("geeks"));
	}

}
