import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TagValidator {


	public boolean validateTag(String text) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<text.length(); i++) {
			char charAtI = text.charAt(i);
			if(charAtI == ')'){
				if(stack.isEmpty()){
					return false;
				}
				stack.pop();
			} else if(charAtI == '('){
				stack.push(charAtI);
			}
		}

		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public boolean validateTagAll(String text) {
		if(text == null || text.length() <2){
			return false;
		}

		Set<Character> oepnTagSet = new HashSet<Character>();
		oepnTagSet.add('(');
		oepnTagSet.add('{');
		oepnTagSet.add('[');
		
		Map<Character, Character> closeTagMap = new HashMap<Character, Character>();
		closeTagMap.put(']', '[');
		closeTagMap.put('}', '{');
		closeTagMap.put(')', '(');

		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<text.length(); i++) {
			char charAtI = text.charAt(i);
			if(oepnTagSet.contains(charAtI)){
				stack.push(charAtI);
				continue;
			}
			
			if(closeTagMap.containsKey(charAtI)) {
				if(stack.isEmpty()){
					return false;
				}	
				if(stack.pop() != closeTagMap.get(charAtI)) {
					return false;
				}				
			}			
		}	
		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args) {
		TagValidator tv = new TagValidator();
		System.out.println(tv.validateTagAll("()()(()()(()))"));
		System.out.println(tv.validateTagAll("()()(()()(()))("));
		System.out.println(tv.validateTagAll("()()(()()((()))"));

		System.out.println(tv.validateTagAll("[{()}]"));
		System.out.println(tv.validateTagAll("[{(})]"));	
		System.out.println(tv.validateTagAll("[()]{}{[()()]()}"));
		System.out.println(tv.validateTagAll("[(])"));
		System.out.println(tv.validateTagAll("{([])}"));
		System.out.println(tv.validateTagAll("()"));
		System.out.println(tv.validateTagAll("([]"));



	}
}
