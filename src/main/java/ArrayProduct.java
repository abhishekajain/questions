import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ArrayProduct {

	public static int highestProductOf3(int[] intArray) {

		// calculate the highest product of three numbers
		int len = intArray.length;
		if (len < 3) {
			throw new RuntimeException();
		}

		if (len == 3) {
			return intArray[0] * intArray[1] * intArray[2];
		}
		int[] result = new int[3];

		int m = 0;
		int b = 0;

		int t = Math.max(Math.max(intArray[0], intArray[1]), intArray[2]);

		if (t == intArray[0]) {
			m = Math.max(intArray[1], intArray[2]);
			b = Math.min(intArray[1], intArray[2]);
		} else if (t == intArray[1]) {
			m = Math.max(intArray[0], intArray[2]);
			b = Math.min(intArray[0], intArray[2]);
		} else if (t == intArray[2]) {
			m = Math.max(intArray[1], intArray[0]);
			b = Math.min(intArray[1], intArray[0]);
		}

		int count = 3;
		while (count < len) {
			int temp = intArray[count++];
			if (temp > m && temp > t) {
				b = m;
				m = t;
				t = temp;
			} else if (temp > m && temp < t) {
				b = m;
				m = temp;
			} else if (temp < m && temp > b) {
				b = temp;
			}
		}

		return t * m * b;
	}

	// tests

	@Test
	public void shortArrayTest() {
		final int actual = highestProductOf3(new int[] { 1, 2, 3, 4 });
		final int expected = 24;
		assertEquals(expected, actual);
	}

	@Test
	public void longerArrayTest() {
		final int actual = highestProductOf3(new int[] { 6, 1, 3, 5, 7, 8, 2 });
		final int expected = 336;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayHasOneNegativeTest() {
		final int actual = highestProductOf3(new int[] { -5, 4, 8, 2, 3 });
		final int expected = 96;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayHasTwoNegativesTest() {
		final int actual = highestProductOf3(new int[] { -10, 1, 3, 2, -10 });
		final int expected = 300;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayIsAllNegativesTest() {
		final int actual = highestProductOf3(new int[] { -5, -1, -3, -2 });
		final int expected = -6;
		assertEquals(expected, actual);
	}

	@Test(expected = Exception.class)
	public void exceptionWithEmptyArrayTest() {
		highestProductOf3(new int[] {});
	}

	@Test(expected = Exception.class)
	public void exceptionWithOneNumberTest() {
		highestProductOf3(new int[] { 1 });
	}

	@Test(expected = Exception.class)
	public void exceptionWithTwoNumbersTest() {
		highestProductOf3(new int[] { 1, 1 });
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ArrayProduct.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}