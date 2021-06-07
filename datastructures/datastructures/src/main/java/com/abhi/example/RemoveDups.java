package com.abhi.example;

public class RemoveDups {

	public static char[] removeDuplicates(char[] str) {
		if (str == null)
			return str;
		int len = str.length;
		if (len < 2)
			return str;
		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return str;
	}

	public static char[] removeDuplicatesEff(char[] str) {
		if (str == null)
			return str;
		int len = str.length;
		if (len < 2)
			return str;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		return str;
	}
	
	public static void main(String[] args){
		
		char[] test = {'a', 'a', 'a', 'b', 'b', 'b', 'c'};
		System.out.println(removeDuplicatesEff(test));
		System.out.println(removeDuplicates(test));
	}

}
