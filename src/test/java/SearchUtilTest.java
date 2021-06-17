import org.junit.Assert;
import org.junit.Test;

public class SearchUtilTest {

    @Test
    public void testFindMinRight(){
        int[] nums = {4,5,6,7,0,1,2};
        Assert.assertEquals(0,SearchUtil.findMinimum(nums));
    }

    @Test
    public void testFindMinSorted(){
        int[] nums = {4,5,6,7,8,9,10};
        Assert.assertEquals(4,SearchUtil.findMinimum(nums));
    }

    @Test
    public void testFindMinLeft(){
        int[] nums = {7,0,1,2,3,4,5,6};
        Assert.assertEquals(0,SearchUtil.findMinimum(nums));
    }
}
