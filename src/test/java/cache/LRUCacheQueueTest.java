package cache;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheQueueTest {

    @Test
    public void testCache(){
        LRUCacheQueue cache = new LRUCacheQueue(2);
        cache.put(1,1);
        cache.put(2,2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3,3);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(4,4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void testCacheCapacity1(){
        LRUCacheQueue cache = new LRUCacheQueue(1);
        cache.put(2,1);
        Assert.assertEquals(1, cache.get(2));
        cache.put(3,2);
        Assert.assertEquals(-1, cache.get(2));
        Assert.assertEquals(2,cache.get(3));
    }
}
