package org.abhi.array;

import org.junit.Test;

import static org.abhi.array.ArrayUtil.findBusiestPeriod;
import static org.abhi.array.ArrayUtil.arrayOfArrayProducts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class ArrayUtilTest {

    @Test
    public void testFindBusyPeriod(){
        int[][] data = { {1487799425, 14, 1},
                {1487799425, 4,  0},
                {1487799425, 2,  0},
                {1487800378, 10, 1},
                {1487801478, 18, 0},
                {1487801478, 18, 1},
                {1487901013, 1,  0},
                {1487901211, 7,  1},
                {1487901211, 7,  0} };
        assertEquals(1487801478, findBusiestPeriod(data));
    }

    @Test
    public void testProductArray(){
        int[] input1 = {8, 10, 2};
        int[] expected1= {20, 16, 80};
        assertArrayEquals(expected1, arrayOfArrayProducts(input1));
        int[] input2 = {2, 7, 3, 4};
        int[] expected2= {84, 24, 56, 42};
        assertArrayEquals(expected2,  arrayOfArrayProducts(input2));
    }
}
