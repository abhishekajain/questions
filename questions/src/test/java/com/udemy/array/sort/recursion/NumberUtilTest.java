package com.udemy.array.sort.recursion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberUtilTest {
	
	@Test
	public void testCalculateFactorial() {
		assertEquals(2l, NumberUtil.calculateFactorial(2));
		assertEquals(6l, NumberUtil.calculateFactorial(3));
		assertEquals(24l, NumberUtil.calculateFactorial(4));
		assertEquals(120l, NumberUtil.calculateFactorial(5));
		assertEquals(1l, NumberUtil.calculateFactorial(0));
		assertEquals(1l, NumberUtil.calculateFactorial(1));
		assertEquals(720l, NumberUtil.calculateFactorial(6));
	}
	
	@Test
	public void testRecursiveFactorial() {
		assertEquals(2l, NumberUtil.recursiveFactorial(2));
		assertEquals(6l, NumberUtil.recursiveFactorial(3));
		assertEquals(24l, NumberUtil.recursiveFactorial(4));
		assertEquals(120l, NumberUtil.recursiveFactorial(5));
		assertEquals(1l, NumberUtil.recursiveFactorial(0));
		assertEquals(1l, NumberUtil.recursiveFactorial(1));
		assertEquals(720l, NumberUtil.recursiveFactorial(6));
	}
	
	@Test(expected = IllegalArgumentException.class)	
	public void testCalculateFactorialNegative() {
		NumberUtil.calculateFactorial(-22);
	}	
	
	@Test(expected = IllegalArgumentException.class)	
	public void testRecursiveFactorialNegative() {
		NumberUtil.recursiveFactorial(-22);
	}	
}
