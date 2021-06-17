import org.junit.Assert;
import org.junit.Test;

public class MultiDimensionArrayUtilTest {

    @Test
    public void testRotateArrayClockwise(){
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        MultiDimensionArrayUtil.rotateArrayClockwise(input);
        int[][] expected = {{5,1,2,3},{9,10,6,4},{13,11,7,8},{14,15,16,12}};
        Assert.assertArrayEquals(expected, input);
    }

    @Test
    public void testminimumMoves(){
        String[] grid = {".X.",".X.", "..."};
        Assert.assertEquals(3, MultiDimensionArrayUtil.minimumMoves(grid,0,0,0,2));
    }
}
