package com.abhi.example;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BalancedBracket
{ 	
	public static Stack<Character> parse(String str){
		IntStream stream =  str.chars().filter(c -> c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')');
		List<Integer> intList = stream.boxed().collect(Collectors.toList());
		Stack<Character> stack = new Stack<Character>();
		for(Integer item : intList){
			stack.push(new Character(((char)item.intValue())));
		}		
		return stack;
	}
	//compare hasBalancedBrackets //return 0 if error otherwise return 1
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
			return 1;//if success
		}else{
			return 0;//error
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