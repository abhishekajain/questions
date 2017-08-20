package com.abhi.datastructure;

import java.util.Arrays;
import java.util.List;

public class Boggle {

	static String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
	static List<String> dictionaryList = Arrays.asList(dictionary);

	
	static char[][] boggle   = {{'G','I','Z'},
            					{'U','E','K'},
            					{'Q','S','E'}};
	
	static boolean isWord(String str){
		return dictionaryList.contains(str);
	}
	
	static void createWords(){
		int m = boggle.length;
		int n = boggle[0].length;
//		boolean[][] visted = new boolean[m][n];
		for(int i=0; i<boggle.length; i++){
			char[] newChars = boggle[i];
			for(int j=0; j<newChars.length; j++){
				createWordsUtil(new boolean[m][n], i, j, "");
			}
		}
	}
	
	static void createWordsUtil(boolean[][] visited, int i, int j, String str) {
		visited[i][j] = true;
		str = str+boggle[i][j];
		if(isWord(str)){
			System.out.println(str);
		}
		// Traverse 8 adjacent cells of boggle[i][j]
	    for (int row=i-1; row<=i+1 && row<boggle.length; row++){
	      for (int col=j-1; col<=j+1 && col<boggle[0].length; col++){
	        if (row>=0 && col>=0 && !visited[row][col]){
	        	createWordsUtil(visited, row, col, str);
	        }
	      }
	    }
	    // remove last char from string and mark visited of current cell as false so that loop can start from next direction
	    str = str.substring(0, str.length()-1);
	    visited[i][j] = false;
	}
	
	public static void main(String[] args) {
		createWords();
	}
}
