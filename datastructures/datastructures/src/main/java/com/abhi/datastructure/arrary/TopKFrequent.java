package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/*

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 = k = number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/
public class TopKFrequent {

	public static void main(String[] args) {
		TopKFrequent topKFrequent = new TopKFrequent();
		String[] arr1 = {"i", "love", "leetcode", "i", "love", "coding"};
		topKFrequent.topKFrequent(arr1,2);
		String[] arr2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		topKFrequent.topKFrequent(arr2,4);
	}

    public List<String> topKFrequent(String[] words, int k) {
        
		HashSet<WordFreq> set = new HashSet<WordFreq>();
		for(String word:words){
			WordFreq wordFreq = new WordFreq(word);
			if(!set.add(wordFreq)){
				WordFreq wordFreqSetOut = null;
				for(WordFreq wordFreqSet:set){
					if(wordFreq.equals(wordFreqSet)){
						wordFreqSetOut = wordFreqSet;
						break;
					}
				}
				set.remove(wordFreqSetOut);
				wordFreqSetOut.increaseCount();
				set.add(wordFreqSetOut);
			}else{
				set.add(wordFreq);
			}
		}
		//System.out.println(set);
		TreeSet<WordFreq> treeSet = new TreeSet<WordFreq>(new Comparator<WordFreq>() {

			@Override
			public int compare(WordFreq o1, WordFreq o2) {
				int compare  = o2.count.compareTo(o1.count);
				if(compare == 0) {
					return o1.word.compareTo(o2.word);
				}
				return compare;
			}
			
		
		});
		treeSet.addAll(set);
		System.out.println(treeSet);
		
		List<String> result = new ArrayList<String>();
		
		WordFreq wordFreq = treeSet.pollFirst();
		while(wordFreq != null) {
			result.add(wordFreq.word);
            k--;
			wordFreq = treeSet.pollFirst();
			if(k==0) {			
				break;
			}
		}
		System.out.println(result);
		return result;
    }


	class WordFreq {
		String word = null;
		Integer count = new Integer(1);

		public WordFreq(String word) {
			this.word = word;
		}

		public void increaseCount() {
			this.count = this.count+1;
		}

		@Override
		public int hashCode() {
			return this.word.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			WordFreq wordFreq = (WordFreq)obj;
			return this.word.equals(wordFreq.word);
		}

		@Override
		public String toString() {
			return this.word+":"+this.count;
		}
	}
}
