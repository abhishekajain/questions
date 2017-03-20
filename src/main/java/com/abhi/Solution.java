package com.abhi;

import java.util.HashMap;

import java.util.Map;

public class Solution
{ 

	public static int hasBalancedBrackets(String str)
	{
	    if(str == null || str.length() <= 1){
	        return 0;
	    }
	    
	   Map<Integer, Bracket> mapBracket = new HashMap<Integer, Bracket>();
        
        mapBracket.put(1, new Bracket('(',')'));
        mapBracket.put(2, new Bracket('{','}'));  
        mapBracket.put(3, new Bracket('[',']'));
        mapBracket.put(4, new Bracket('<','>'));
	    
	    for(Integer key:mapBracket.keySet()){
	        if(findBalanced(str, mapBracket.get(key)) == 0){
	            return 0;
	        }
	    }
	    return 1;
	}
	
	public static int findBalanced(String str, Bracket bracket){
	    char[] splitArr = str.toCharArray();
	    for(int i=0; i<splitArr.length; i++){
	        char c = splitArr[i];
	        if(c == bracket.open){
	            String newStr = str.substring(1);
	            char[] newCharArr = newStr.toCharArray();
	            for(int j=0; j<newCharArr.length; j++){
	                char nextC = newCharArr[j];
	                if(nextC == bracket.close){
	                    return 1;
	                }else if(nextC == bracket.open){
	                    return findBalanced(newStr, bracket);
	                }
	            }
	            return 0;
	        }
	    }
	    return 1;
	}
	
	static class Bracket{
	    char open;
	    char close;
	    
	    Bracket(char open, char close){
	        this.open = open;
	        this.close = close;
	    }
	}
	
	public static void main(String[] args){
		System.out.println(hasBalancedBrackets("(h[e{1o}!]~)()()()("));
	}
}