import org.junit.Assert;
import org.junit.Test;

public class SortUtilTest {

    @Test
    public void testBubbleSort(){
        int[] expected = {-1,0,2,8,10};
        int[] input = {2,8,0,-1,10};
        SortUtil.bubbleSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testBubbleSortShortArray(){
        int[] expected = {-1};
        int[] input = {-1};
        SortUtil.bubbleSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testQucikSort(){
        int[] expected = {-1,0,2,8,10};
        int[] input = {2,8,0,-1,10};
        SortUtil.qucikSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testQucikSortBigArray(){
        int[] expected = {-10,-5,-1,0,2,2,4,5,8,10,11,12,33,34};
        int[] input =    {2,8,0,-1,10,-10,4,5,33,2,12,11,-5,34};
        SortUtil.qucikSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testQucikSortShortArray(){
        int[] expected = {-1};
        int[] input = {-1};
        SortUtil.qucikSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort(){
        int[] expected = {-1,0,2,8,10};
        int[] input = {2,8,0,-1,10};
        SortUtil.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortBigArray(){
        int[] expected = {-10,-5,-1,0,2,2,4,5,8,10,11,12,33,34};
        int[] input =    {2,8,0,-1,10,-10,4,5,33,2,12,11,-5,34};
        SortUtil.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSortShortArray(){
        int[] expected = {-1};
        int[] input = {-1};
        SortUtil.mergeSort(input);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMerge(){
        int[] expected = {-1,0,2,8,10};
        int[] input = {-1,0,2,8,10};
        SortUtil.merge(input, 0,2, 4);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMerge2(){
        int[] expected = {-1,0,2,8,10};
        int[] input = {-1,0,2,8,10};
        SortUtil.merge(input, 1,1,4);
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testMerge3(){
        int[] expected = {-1,0,0,1,2,3,8,10};
        int[] input =    {-1,0,0,1,2,3,8,10};
        SortUtil.merge(input, 0,2,5);
        Assert.assertArrayEquals(expected, input);
    }
}
