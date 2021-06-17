import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RomanToInteger {

	public int romanToInt(String s) {
		Set<Character> prependingChars = new HashSet<>();
		prependingChars.add('I');
		prependingChars.add('X');
		prependingChars.add('C');

		Map<String, Integer> romans = new HashMap<>();
		romans.put("I", 1);
		romans.put("V", 5);
		romans.put("X", 10);
		romans.put("L", 50);
		romans.put("C", 100);
		romans.put("D", 500);
		romans.put("M", 1000);
		romans.put("IV", 4);
		romans.put("IX", 9);
		romans.put("XL", 40);
		romans.put("XC", 90);
		romans.put("CD", 400);
		romans.put("CM", 900);

		int result = 0;

		char[] prependChar = new char[2];
		String str = "";
		boolean charPrepended = false;
		
		for(int i=0;i<s.length();i++) {
//			str = s.
		}
		
		
		for (Character c : s.toCharArray()) {
			if (prependingChars.contains(c)) {
				prependChar[0] = c;
				charPrepended = true;
				continue;
			}
			if (charPrepended) {
				prependChar[1] = c;
				str = new String(prependChar);
				if (romans.get(str) == null) {
					
				}
				charPrepended = false;
			} else {
				prependChar[0] = c;
				str = new String(prependChar);
			}
			result = result + romans.get(str);
			str = "";
		}
		return result;
	}

}
