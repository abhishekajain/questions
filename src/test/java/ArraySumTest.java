import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraySumTest {

    @Test
    public void testfindIp(){
        List<String> result = ArraySum.findIp("12314592");
        String[] ips = result.toArray(new String[0]);
        Assert.assertTrue(true);
    }

    @Test
    public void testEqualStack(){
        Integer[] h1 = {3, 2, 1, 1, 1};
        Integer[] h2 = {4, 3, 2};
        Integer[] h3 = {1, 1, 4, 1};
        Assert.assertEquals(5, ArraySum.equalStacks(Arrays.asList(h1), Arrays.asList(h2), Arrays.asList(h3)));
    }

    @Test
    public void testlongestSubString(){
        Assert.assertEquals("abcd", ArraySum.longestSubString("abcda"));
        Assert.assertEquals("bdangh", ArraySum.longestSubString("aabdanghn"));
        Assert.assertEquals("a", ArraySum.longestSubString("aaaa"));
        Assert.assertEquals("dersf", ArraySum.longestSubString("dersf"));
        Assert.assertEquals("", ArraySum.longestSubString(""));

    }

    @Test
    public void testlongestSubString1(){
        Assert.assertEquals("abcd", ArraySum.longestSubString1("abcda"));
        Assert.assertEquals("bdangh", ArraySum.longestSubString1("aabdanghn"));
        Assert.assertEquals("a", ArraySum.longestSubString1("aaaa"));
        Assert.assertEquals("dersf", ArraySum.longestSubString1("dersf"));
        Assert.assertEquals("", ArraySum.longestSubString1(""));

    }
}
