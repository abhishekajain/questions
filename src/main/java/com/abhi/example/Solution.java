package com.abhi.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{ 
	//return 0 if error otherwise return 1
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
	                if(nextC == bracket.close || nextC == bracket.open){
	                    findBalanced(newStr.substring(j+1), bracket);
	                }
	            }
	        }else if(c == bracket.close){
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
	
	public static Stack<Character> parse(String str){
		IntStream stream =  str.chars().filter(c -> c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')');
		List<Integer> intList = stream.boxed().collect(Collectors.toList());
		Stack<Character> stack = new Stack<Character>();
		for(Integer item : intList){
			stack.push(new Character(((char)item.intValue())));
		}		
		return stack;
	}
	
	public static int compare(Stack<Character> charStack){
		Stack<Character> newStack = new Stack<Character>();
		
		while(!charStack.isEmpty()){
			Character ch = charStack.pop();
			if(newStack.isEmpty()){
				newStack.push(ch);
			}else{
				Character chCompare = newStack.pop();
				if(chCompare == '}'){
					if(ch == '{'){
						
					}else{
						newStack.push(chCompare);
						newStack.push(ch);
					}
				}else if(chCompare == ']'){
					if(ch == '['){
						
					}else{
						newStack.push(chCompare);
						newStack.push(ch);
					}
				}else if(chCompare == ')'){
					if(ch == '('){
						
					}else{
						newStack.push(chCompare);
						newStack.push(ch);
					}
				}
			}
		}
		
		if(newStack.isEmpty()){
			return 0;
		}else{
			return -1;
		}

	}
	/**
	 * [(, [, {, }, ], ), (, ), (, ), (, ), (]
		[(, [, {, }, ], ), (, ), (, ), (, ), (, )]
		[{, [, ], (, ), }]
		[{, [, (, ], ), }]
		[{, [, }]
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(compare(parse("(h[e{1o}!]~)()()()(")));
		System.out.println(compare(parse("(h[e{1o}!]~)()()()()")));
		System.out.println(compare(parse("{ [ ] ( ) }")));
		System.out.println(compare(parse("{ [ ( ) ] }")));
		System.out.println(compare(parse("{ [ ] }")));
	}
}