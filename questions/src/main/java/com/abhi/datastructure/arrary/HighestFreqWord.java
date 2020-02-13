package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class HighestFreqWord {
	
	public static void main(String[] args) {
		double di = 2;
		double dj = 3;
		System.out.println(di/dj);
		System.out.println(3%2);
		
		HighestFreqWord highestFreqWord = new HighestFreqWord();
		List<String> ignoreWords = new ArrayList<String>();
		ignoreWords.add("are");

		System.out.println(highestFreqWord.mostFrq("rose are red but some other flower are red too flower", ignoreWords));
		System.out.println(highestFreqWord.mostFrq("rose are's rose", ignoreWords));

	}
	

	public List<String> mostFrq(String para, List<String> ignoreWords){
		
		List<String> ignoreWordsLowercase = new ArrayList<String>();
		
		para = para.replaceAll("[^A-Za-z ]", " ");
		String[] words = para.split("\\s+");
		
		for(String ignore: ignoreWords) {
			ignoreWordsLowercase.add(ignore.toLowerCase());
		}
		
		HashSet<WordFreq> set = new HashSet<WordFreq>();
		
		for(String word:words) {
			if(!ignoreWordsLowercase.contains(word)) {
				WordFreq wordFreq = new WordFreq(word);
				if(set.contains(wordFreq)) {
					WordFreq wordFreqSetOut = null;
					for(WordFreq wordFreqSet: set) {
						if(wordFreqSet.equals(wordFreq)) {	
							wordFreqSetOut = wordFreqSet;
							break;
						}
					}
					if(wordFreqSetOut != null) {
						set.remove(wordFreqSetOut);
						wordFreqSetOut.increaseCount();
						set.add(wordFreqSetOut);
					}
				}else {
					set.add(wordFreq);
				}
			}
		}
		
		
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
		System.out.println("set>>>"+set);
		System.out.println("treeSet>>>"+treeSet);
		
		List<String> result = new ArrayList<String>();
		
		WordFreq wordFreq = treeSet.pollFirst();
		int wordFreqCount = wordFreq.count;
		while(wordFreq != null) {
			result.add(wordFreq.word);
			wordFreq = treeSet.pollFirst();
			if(wordFreq == null || wordFreq.count != wordFreqCount) {
				wordFreq = null;
				break;
			}
		}
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
