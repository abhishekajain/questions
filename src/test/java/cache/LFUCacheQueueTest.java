package cache;

import org.junit.Assert;
import org.junit.Test;

public class LFUCacheQueueTest {

    @Test
    public void test(){
        LFUCacheQueue cache = new LFUCacheQueue(3);
        cache.set(2,2);
        cache.set(1,1);
        Assert.assertEquals(2,cache.get(2));
        Assert.assertEquals(1,cache.get(1));
        Assert.assertEquals(2,cache.get(2));
        cache.set(3,3);
        cache.set(4,4);
        Assert.assertEquals(-1,cache.get(3));
        Assert.assertEquals(2,cache.get(2));
        Assert.assertEquals(1,cache.get(1));
        Assert.assertEquals(4,cache.get(4));
    }
}
