package com.abhi.datastructure.arrary;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TestArraySortUtil {
		
	@Test
	public void testSelectionSort() {
		int count = 10;
		while(count >= 0) {
			ArraySortUtil sortUtil = new ArraySortUtil(count*10);
			sortUtil.selectionSort();
			assertTrue(Arrays.equals(sortUtil.getSortedElements(), sortUtil.getElements()));
			count--;
		}
	}
	
	@Test
	public void testInsertionSort() {
		int count = 10;
		while(count >= 0) {
			ArraySortUtil sortUtil = new ArraySortUtil(count*10);
			sortUtil.insertionSort(1);
			assertTrue(Arrays.equals(sortUtil.getSortedElements(), sortUtil.getElements()));
			count--;
		}
	}
	
	@Test
	public void testShellSort() {
		int count = 10;
		while(count >= 0) {
			ArraySortUtil sortUtil = new ArraySortUtil(count*10);
			sortUtil.shellSort();
			assertTrue(Arrays.equals(sortUtil.getSortedElements(), sortUtil.getElements()));
			count--;
		}
	}

}
