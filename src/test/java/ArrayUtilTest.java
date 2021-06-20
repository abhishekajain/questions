import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtilTest {

    @Test
    public void testFindDuplicate(){
        int[] n = {1,3,4,1,5,4,6};
        Assert.assertEquals(1,ArrayUtil.findRepeat(n));
    }

//    @Test
    public void testfindRepeatBinary(){
        int[] n = {1,3,4,2,5,4,6};
        Assert.assertEquals(4, ArrayUtil.findRepeatBinary(n, 1, 6));
    }

    @Test
    public void testfindDuplicate(){
        int[] n = {2,3,1,3};
        Assert.assertEquals(3, ArrayUtil.findDuplicate(n));
    }

    @Test
    public void testlargestRectangle(){
        int[] input = {1, 2, 3, 4, 5};
        Assert.assertEquals(9,ArrayUtil.largestRectangle(input));
        int[] input2 = {3, 2, 3};
        Assert.assertEquals(6,ArrayUtil.largestRectangle(input2));
    }

    @Test
    public void teslargestRectangleOptimized(){
        int[] input = {1, 2, 3, 4, 5};
        Assert.assertEquals(9,ArrayUtil.largestRectangleOptimized(input));
        int[] input2 = {3, 2, 3};
        Assert.assertEquals(6,ArrayUtil.largestRectangleOptimized(input2));
    }

    @Test
    public void testRiddle(){
        long[] input = {3, 5, 4, 7, 6, 2};
        long[] expected = {7, 6, 4, 4, 3, 2};
        Assert.assertEquals(expected, ArrayUtil.riddle(input));
    }

    @Test
    public void testwhatFlavors1(){
        int[] cost = {1, 4, 5, 3, 2};
        int money = 4;
        int[] expected = {1,4};
        Assert.assertArrayEquals(expected, ArrayUtil.whatFlavors2(cost, money));
    }

    @Test
    public void testwhatFlavors2(){
        int[] cost = {2, 2, 4, 3};
        int money = 4;
        int[] expected = {1,2};
        Assert.assertArrayEquals(expected, ArrayUtil.whatFlavors2(cost, money));
    }

    @Test
    public void testWhatFlacours3(){
        int[] cost = {7, 2, 5, 4, 11};
        int money = 12;
        int[] expected = {1,3};
        Assert.assertArrayEquals(expected, ArrayUtil.whatFlavors2(cost, money));
    }

    @Test
    public void testGgetNextMax(){
        Assert.assertEquals("1254", ArrayUtil.getNextMax("1245"));
        Assert.assertEquals("9843", ArrayUtil.getNextMax("9843"));
        Assert.assertEquals("9348", ArrayUtil.getNextMax("8943"));
        Assert.assertEquals("8324", ArrayUtil.getNextMax("8243"));
    }

    @Test
    public void testMergeSort(){
        String input = "87686870924";
        char[] chars = input.toCharArray();
        ArrayUtil.mergeSort(chars);
        String expected = "02466778889";
        Assert.assertArrayEquals(expected.toCharArray(), chars);
    }

    @Test
    public void testcheckPossibility(){
        int[] numsTrue = {4,2,3};
        Assert.assertTrue(ArrayUtil.checkPossibility(numsTrue));
        int[] numsFalse= {4,2,1};
        Assert.assertFalse(ArrayUtil.checkPossibility(numsFalse));
        int[] numsTrue1 = {4,2,3,5,9};
        Assert.assertTrue(ArrayUtil.checkPossibility(numsTrue1));
        int[] numsFalse1 = {4,2,3,5,9,0};
        Assert.assertFalse(ArrayUtil.checkPossibility(numsFalse1));
        int[] numsFalse2 = {4,2,3,5,3,9,10};
        Assert.assertFalse(ArrayUtil.checkPossibility(numsFalse2));
    }

    @Test
    public void testcheckSubarraySum(){
        int[] nums = {23, 2, 4, 6, 7};
        Assert.assertTrue(ArrayUtil.checkSubarraySum(nums,6));
        int[] numsAll = {23, 2, 6, 4, 7};
        Assert.assertTrue(ArrayUtil.checkSubarraySum(numsAll, 6));
        int[] numsBetween = {23, 2, 6, 4, 5};
        Assert.assertTrue(ArrayUtil.checkSubarraySum(numsBetween, 6));
        Assert.assertTrue(ArrayUtil.checkSubarraySum(numsBetween, 9));
        int[] nums9 = {1,2,3,4,5,6,7};
        Assert.assertTrue(ArrayUtil.checkSubarraySum(nums9, 18));

    }

    @Test
    public void testmergeInterval(){
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(3);
        input.add(input1);
        List<Integer> input2 = new ArrayList<>();
        input2.add(6);
        input2.add(9);
        input.add(input2);

        List<Integer> input3 = new ArrayList<>();
        input3.add(2);
        input3.add(5);
        List<List<Integer>> result = ArrayUtil.mergeInterval(input, input3);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testmergeInterval2(){
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> input1 = new ArrayList<>();
        input1.add(1);
        input1.add(2);
        input.add(input1);
        List<Integer> input2 = new ArrayList<>();
        input2.add(3);
        input2.add(5);
        input.add(input2);
        List<Integer> input3 = new ArrayList<>();
        input3.add(6);
        input3.add(7);
        input.add(input3);
        List<Integer> input4 = new ArrayList<>();
        input4.add(8);
        input4.add(10);
        input.add(input4);
        List<Integer> input5 = new ArrayList<>();
        input5.add(12);
        input5.add(16);
        input.add(input5);

        List<Integer> newInterval = new ArrayList<>();
        newInterval.add(4);
        newInterval.add(9);
        List<List<Integer>> result =  ArrayUtil.mergeInterval(input, newInterval);
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void tesfindPairsWithGivenDifference(){
        int[] input = {0, -1, -2, 2, 1};
        int[][] result = ArrayUtil.findPairsWithGivenDifference(input, 1);
    }

    @Test
    public void testminRefuelStops(){
        int[][] stations =  {{10,60},{20,30},{30,30},{60,40}};
        int result = ArrayUtil.minRefuelStops(100, 10, stations);
        int[][] stations2 =  {{10,100}};
        int result2 = ArrayUtil.minRefuelStops(100, 1, stations2);

        int[][] stations3 =  {{25,25}, {50,25}, {75,25}};
        int result3 = ArrayUtil.minRefuelStops(100, 25, stations3);

        int[][] stations4 =  {{13,21},{26,115},{100,47},{225,99},{299,141},{444,198},{608,190},{636,157},{647,255},{841,123}};
        int result4 = ArrayUtil.minRefuelStops(1000, 299, stations4);
    }

    @Test
    public void testsearchpivot(){
        int[] nums = {4,5,6,7,0,1,2};
        Assert.assertEquals(4, ArrayUtil.search(nums, 0));

        int[] nums1 = {5,1,2,3,4};
        Assert.assertEquals(1, ArrayUtil.search(nums1, 1));

        Assert.assertEquals(1, ArrayUtil.search(nums, 5));
    }

    @Test
    public void testbinarysearch(){
        int[] nums = {4,5,6,7,8,9,10};
        Assert.assertEquals(-1, ArrayUtil.binarySearch(nums, 0));
        Assert.assertEquals(3, ArrayUtil.binarySearch(nums, 7));
        Assert.assertEquals(5, ArrayUtil.binarySearch(nums, 9));
    }
}
