package com.abhi.datastructure.arrary;

/**
 * String[] words = new String[]{ "ptolemaic", "retrograde", "supplant",
 * "undulate", "xenoepist", "asymptote", // <-- rotates here! "babka",
 * "banoffee", "engender", "karpatka", "othellolagkage", };
 * 
 * I want to learn some big words so people think I'm smart. I opened up a
 * dictionary to a page in the middle and started flipping through, looking for
 * words I didn't know. I put each word I didn't know at increasing indices in a
 * huge array I created in memory. When I reached the end of the dictionary, I
 * started from the beginning and did the same thing until I reached the page I
 * started at.
 * 
 * Now I have an array of words that are mostly alphabetical, except they start
 * somewhere in the middle of the alphabet, reach the end, and then start from
 * the beginning of the alphabet. In other words, this is an alphabetically
 * ordered array that has been "rotated." For example: Write a function for
 * finding the index of the "rotation point," which is where I started working
 * from the beginning of the dictionary. This array is huge (there are lots of
 * words I don't know) so we want to be efficient here.
 * 
 * @author abhishek.ajain
 *
 */

public class RotationPoint {

	public static void main(String[] args) {
		String[] words = new String[]{ "p", "q", "r", "s", "t", "u", "x", "y", 
				"a", // <-- rotates here! "babka",
				  "b", "e", "k", "o", };
		System.out.println(rotationIndex(words, 0, words.length-1, Math.abs(words.length/2)));
	}

	public static int rotationIndex(String[] strArray, int startIndex, int lastIndex, int middle) {
		String str = strArray[middle];
		String strP1 = strArray[middle + 1];
		String strM1 = strArray[middle - 1];
		int compareM1 = str.compareTo(strM1);
		int compareP1 = str.compareTo(strP1);		
		if (compareM1 > 0 && compareP1 > 0) {
			return middle+1;
		} else if (compareM1 < 0 && compareP1 > 0) {
			return rotationIndex(strArray,0, middle, Math.abs(middle/2));			
		} else if (compareM1 > 0 && compareP1 < 0) {
			return rotationIndex(strArray,middle-1, strArray.length-1, (Math.abs((strArray.length-middle)/2)));
		} else {
			return middle;
		}
	}

}
