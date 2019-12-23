package com.abhi.datastructure.arrary;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestArraySortUtil {
	
	
	@Test
	public void testSelectionSort() {
		int count = 10;
		while(count >= 0) {
			ArraySortUtil sortUtil = new ArraySortUtil(count*10);
			sortUtil.selectionSort();
			this.testSortedAssert(sortUtil.getElements());
			count--;
		}
	}
	
	private void testSortedAssert(int[] elements) {
		assertTrue(this.validateSorting(elements));
	}
	
	private boolean validateSorting(int[] elements) {
		for(int i=0; i<elements.length-1; i++) {
			if(elements[i] > elements[i+1]) {
				return false;
			}
		}
		return true;
	}

}
