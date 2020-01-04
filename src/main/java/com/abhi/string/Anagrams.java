package com.abhi.string;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

public class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
		char[] chars = p.toCharArray();
		Arrays.sort(chars);
		int length = chars.length;

		List<Integer> list = new ArrayList<Integer>();

		char[] charsS = s.toCharArray();
		for(int i=0; i<charsS.length-length+1; i++){
			char[] b = new char[length];
			for(int k =0 ; k<length;k++){
				b[k]=charsS[i+k];
			}
			Arrays.sort(b);
			if(isAnagram(chars, b)){
				list.add(i);
			}
		}

		return list;
    }
	//is b anagram of a
    public boolean isAnagram(char[] a, char[] b){
		for(int i=0; i<a.length; i++){
			if(a[i]!=b[i]){
				return false;
			}
		}
		return true;
	}

	public List<Integer> findAnagramsB(String s, String p) {
        int stringLength = s.length();
        int length = p.length();

		char[] chars = p.toCharArray();
		Arrays.sort(chars);
		p = new String(chars);

		List<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<stringLength-length+1; i++){
			String subString = s.substring(i, i+length);
			char[] b = subString.toCharArray();
			Arrays.sort(b);
			subString = new String(b);

			if(p.equals(subString)){
				list.add(i);
			}
		}

		return list;
	}

}