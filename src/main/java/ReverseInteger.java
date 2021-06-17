
public class ReverseInteger {

	public static void main(String args[]) {
		System.out.println(reverse(123));
		System.out.println(reverse(4532));
		System.out.println(reverse(-121));
		System.out.println(reverse(120));
		System.out.println(reverse(0));
		System.out.println(isPalindrome(0));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(10));
		System.out.println(isPalindrome(1000));
	}

	public static boolean isPalindrome(int x) {
		int y = reverse(x);
		if (x < 0)
			return false;
		if (x == y)
			return true;
		return false;
	}

	public static int reverse(int x) {

		int result = 0;
		while (x != 0) {
			int mod = x % 10;
			x = x / 10;
			if (result != 0) {
				result = result * 10 + mod;
			} else {
				result = mod;
			}
		}
		return result;
	}
}

//123
//
//123/10 = 12 123%10=3 r =3
//12/10=1 12%10=2 r=30+2
//1/10=0 1%10=1 r=320+1
