package com.abhi.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MostCount {

	public static void main(String[] args) {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		System.err.println(findMostCount(paragraph, banned));
	}

	public static String findMostCount(String paragraph, String[] banned) {
		String[] punctuation = { "!", "'", ",", ";", "\\.", "\\?" };

		for (String str : punctuation)
			paragraph = paragraph.replaceAll(str, "");

		List<String> bannedList = Arrays.asList(banned);

		String[] words = paragraph.split(" ");

		Map<String, Integer> map = new HashMap<String, Integer>();
		String result = null;
		int count = 0;

		for (String word : words) {
			word = word.toLowerCase();
			if (!bannedList.contains(word)) {
				if (map.get(word) == null) {
					map.put(word, 1);
				} else {
					map.put(word, map.get(word) + 1);
				}
				if(count<map.get(word)) {
					result =word;
					count = map.get(word);
				}
			}
		}
		return result;
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		paragraph += ".";

		Set<String> banset = new HashSet<String>();
		for (String word : banned)
			banset.add(word);
		Map<String, Integer> count = new HashMap<String, Integer>();

		String ans = "";
		int ansfreq = 0;

		StringBuilder word = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}

		return ans;
	}

}
