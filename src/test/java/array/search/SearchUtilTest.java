package array.search;

import org.junit.Assert;
import org.junit.Test;

public class SearchUtilTest {

    @Test
    public void testbinarySearch(){
        int[] nums = {0,2,5,8,10,15,26,37};

        Assert.assertEquals(-1, SearchUtil.binarySearch(nums, 25));
        Assert.assertEquals(1, SearchUtil.binarySearch(nums, 2));
        Assert.assertEquals(4, SearchUtil.binarySearch(nums, 10));
        Assert.assertEquals(5, SearchUtil.binarySearch(nums, 15));
    }

    @Test
    public void testpivotIndex(){
        int[] nums = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        Assert.assertEquals(6, SearchUtil.pivotIndex(nums));
        int[] nums2 = {30, 40, 50, 10, 20};
        Assert.assertEquals(3, SearchUtil.pivotIndex(nums2));
        int[] nums3 = {50, 10, 20, 30, 40};
        Assert.assertEquals(1, SearchUtil.pivotIndex(nums3));
        int[] nums4 = {5, 6, 7, 8, 9, 10, 111, 112, 3};
        Assert.assertEquals(8, SearchUtil.pivotIndex(nums4));
    }

    @Test
    public void testbinarySearchPivot(){
        int[] nums = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        Assert.assertEquals(8, SearchUtil.binarySearchPivot(nums, 3));
        Assert.assertEquals(-1, SearchUtil.binarySearchPivot(nums, 30));
        int[] nums2 = {30, 40, 50, 10, 20};
        Assert.assertEquals(3, SearchUtil.binarySearchPivot(nums2, 10));
        int[] nums3 = {50, 10, 20, 30, 40};
        Assert.assertEquals(0, SearchUtil.binarySearchPivot(nums3, 50));
        int[] nums4 = {5, 6, 7, 8, 9, 10, 111, 112, 3};
        Assert.assertEquals(6, SearchUtil.binarySearchPivot(nums4, 111));
        int[] nums5 = {1};
        Assert.assertEquals(-1, SearchUtil.binarySearchPivot(nums5, 2));
        int[] nums6 = {0,2,5,8,10,15,26,37};
        Assert.assertEquals(6, SearchUtil.binarySearchPivot(nums6, 26));
    }
}
