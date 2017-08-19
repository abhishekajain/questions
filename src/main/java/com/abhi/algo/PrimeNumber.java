package com.abhi.algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Prime number : that is greater than 1 and divided by 1 or itself.
 * Prime numbers can't be divided by other numbers than itself
 * or 1. For example 2, 3, 5, 7, 11.... are the prime numbers.
 * 
 * @author abhishekajain
 *
 */
public class PrimeNumber {

	public static boolean isPrime(int a) {
		if (a <= 1) {
			return false;
		}
		if (a <= 3) {
			return true;
		}
		int m = a / 2;
		for (int i = 2; i < m; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int nextPrime(int a) throws IllegalArgumentException {
		if (a < 0) {
			throw new IllegalArgumentException();
		}
		while (a < Integer.MAX_VALUE) {
			if (isPrime(++a)) {
				break;
			}
		}
		return a;
	}

	@Test
	public void testIsPrime() {
		Assert.assertTrue(isPrime(2));
	}

	@Test
	public void testIsNegativePrime() {
		Assert.assertFalse(isPrime(-1));
	}

	@Test
	public void testIsZeroPrime() {
		Assert.assertFalse(isPrime(0));
	}

	@Test
	public void testIsOnePrime() {
		Assert.assertFalse(isPrime(1));
	}

	@Test
	public void testNextPrime() {
		Assert.assertEquals(2, nextPrime(0));
	}

	@Test
	public void testNextPrime1371() {
		Assert.assertEquals(1373, nextPrime(1371));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNextPrimeIllegal() {
		nextPrime(-1);
	}
}
