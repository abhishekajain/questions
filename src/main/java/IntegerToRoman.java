
public class IntegerToRoman {
	
	public static void main(String args[]) {
		System.out.println(intToRoman(20));
	}
	
	public static String intToRoman(int num) {
		int i = 1, v = 5, x = 10, l = 50, c = 100, d = 500, m = 1000;
		int iv = 4, ix = 9, xl = 40, xc = 90, cd = 400, cm = 900;

		String roman = "";
		while (num / m != 0) {
			roman = roman + "M";
			num = num - m;
		}
		if (num >= cm) {
			roman = roman + "CM";
			num = num - cm;
		}
		while (num / d != 0) {
			roman = roman + "D";
			num = num - d;
		}
		if (num >= cd) {
			roman = roman + "CD";
			num = num - cd;
		}
		while (num / c != 0) {
			roman = roman + "C";
			num = num - c;
		}
		if (num >= xc) {
			roman = roman + "XC";
			num = num - xc;
		}
		while (num / l != 0) {
			roman = roman + "L";
			num = num - l;
		}
		if (num >= xl) {
			roman = roman + "XL";
			num = num - xl;
		}
		while (num / x != 0) {
			roman = roman + "X";
			num = num - x;
		}
		if (num >= ix) {
			roman = roman + "IX";
			num = num - ix;
		}
		while (num / v != 0) {
			roman = roman + "V";
			num = num - v;
		}
		if (num >= iv) {
			roman = roman + "IV";
			num = num - iv;
		}
		while (num != 0) {
			roman = roman + "I";
			num--;
		}
		return roman;
	}
}
