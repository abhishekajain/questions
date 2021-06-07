package com.abhi.datastructure.arrary;

import java.util.HashMap;
import java.util.Map;

public class ShortestCompletingWord {

	public static void main(String[] args) {
		String[] words = { "claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought",
				"use" };
		System.out.println(shortestCompletingWord("iMSlpe4", words));
	}

	public static String shortestCompletingWord(String licensePlate, String[] words) {

		String word = null;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		licensePlate = licensePlate.toLowerCase();

		char[] chars = licensePlate.toCharArray();
		for (char c : chars) {
			if (!Character.isLetter(c)) {
				continue;
			}

			if (map.get(c) == null) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}

		}
		Map<Character, Integer> mapBackUp = new HashMap<Character, Integer>(map);

		int length = 0;

		for (String wordCurrent : words) {
			char[] charscurrent = wordCurrent.toCharArray();

			for (char current : charscurrent) {
				if (map.get(current) != null) {

					if (map.get(current) == 1) {
						map.remove(current);
					} else {
						map.put(current, map.get(current) - 1);
					}
				}

				if (map.isEmpty()) {

					if (length == 0) {
						length = wordCurrent.length();
						word = wordCurrent;
						break;
					}
					if (length > wordCurrent.length()) {
						length = wordCurrent.length();
						word = wordCurrent;

						break;
					}
				}
			}
			map = new HashMap<Character, Integer>(mapBackUp);

		}
		return word;
	}

	public String shortestCompletingWordBetter(String licensePlate, String[] words) {
		String res = "";
		licensePlate = licensePlate.toLowerCase();
		int[] dict = new int[26];
		for (char c : licensePlate.toCharArray()) {
			if (Character.isAlphabetic(c))
				dict[c - 'a']++;
		}

		for (String w : words) {
			if (match(w, dict)) {
				if (res.length() == 0 || res.length() > w.length())
					res = w;
			}
		}
		return res;
	}

	private boolean match(String w, int[] dict) {
		int[] cur = new int[26];
		for (char c : w.toCharArray()) {
			cur[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (dict[i] > cur[i])
				return false;
		}
		return true;
	}
}
