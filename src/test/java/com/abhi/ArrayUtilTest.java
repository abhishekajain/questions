package com.abhi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtilTest {

    @Test
    public void testGetMax(){
        List<String> list = new ArrayList<>();
        list.add("1 97");
        list.add("2");
        list.add("1 20");
        list.add("2");
        list.add("1 26");
        list.add("1 20");
        list.add("2");
        list.add("3");
        list.add("1 91");
        list.add("3");
        List<Integer> result = ArrayUtil.getMax(list);
        Integer[] expected = {26, 91};
        Assert.assertArrayEquals(expected, result.toArray(new Integer[0]));
    }

    @Test
    public void testtwoStacks(){
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);
        Assert.assertEquals(4, ArrayUtil.twoStacksS(10, a, b));
    }

    @Test
    public void testTwoStacks2(){
        List<Integer> a = new ArrayList<>();
        a.add(17);
        a.add(5);
        a.add(0);//22
        List<Integer> b = new ArrayList<>();
        b.add(10);
        b.add(8);
        b.add(2);
        b.add(1);
        b.add(13);
        b.add(1);//35
        b.add(14);
        b.add(18);
        b.add(9);
        b.add(18);
        b.add(16);
        b.add(19);
        b.add(5);
        Assert.assertEquals(9, ArrayUtil.twoStacksS(60, a, b));
    }

    @Test
    public void testTwoStacks3(){
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(11);
        a.add(16);//22
        List<Integer> b = new ArrayList<>();
        b.add(15);
        b.add(8);
        b.add(11);
        Assert.assertEquals(1, ArrayUtil.twoStacksS(5, a, b));
    }

    @Test
    public void testTwoStacks4(){
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(12);
        a.add(15);//22
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(19);
        b.add(16);
        Assert.assertEquals(2, ArrayUtil.twoStacksS(12, a, b));
    }


    @Test
    public void testTwoStacks5(){
        List<Integer> a = new ArrayList<>();
        a.add(13);
        a.add(1);
        a.add(19);//22
        List<Integer> b = new ArrayList<>();
        b.add(14);
        b.add(8);
        b.add(6);
        Assert.assertEquals(2, ArrayUtil.twoStacksS(26, a, b));
    }

    @Test
    public void testTwoStacks6(){
        List<Integer> a = new ArrayList<>();
        a.add(14);
        a.add(0);
        a.add(15);//22
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(2);
        b.add(6);
        b.add(9);
        b.add(0);
        b.add(1);
        Assert.assertEquals(5, ArrayUtil.twoStacksS(19, a, b));
    }

    @Test
    public void testWarmerDays(){
        int[] temps = {65, 68, 66, 69, 70, 74, 73, 74, 76};
        int[] expected = {1, 2, 1, 1, 1, 3, 1 , 1, 0};
        Assert.assertArrayEquals(expected, ArrayUtil.warmerDays(temps));
    }

    @Test
    public void testWarmerDaysFirstMax(){
        int[] temps = {78, 68, 66, 69, 70, 74, 73, 74, 76};
        int[] expected = {0, 2, 1, 1, 1, 3, 1 , 1, 0};
        Assert.assertArrayEquals(expected, ArrayUtil.warmerDays(temps));
    }

    @Test
    public void testdailyTemperatures(){
        int[] temps = {65, 68, 66, 69, 70, 74, 73, 74, 76};
        int[] expected = {1, 2, 1, 1, 1, 3, 1 , 1, -1};
        Assert.assertArrayEquals(expected, ArrayUtil.dailyTemperatures(temps));
    }

    @Test
    public void testdailyTemperaturesFirstMax(){
        int[] temps = {78, 68, 66, 69, 70, 74, 73, 74, 76};
        int[] expected = {-1, 2, 1, 1, 1, 3, 1 , 1, -1};
        Assert.assertArrayEquals(expected, ArrayUtil.dailyTemperatures(temps));
    }

    @Test
    public void testgetMinMax(){
        int[] arr = {78, 68, 66, 69, 70, 74, 73, 74, 76};
        ArrayUtil.Pair pair = ArrayUtil.getMinMax(arr);
        Assert.assertEquals(66, pair.min);
        Assert.assertEquals(78, pair.max);
    }
}
