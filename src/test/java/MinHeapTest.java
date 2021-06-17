import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {

    @Test
    public void testInsert(){
        MinHeap minHeap = new MinHeap(20);
        minHeap.push(15);
        Assert.assertEquals(15, minHeap.getMin());
        minHeap.push(5);
        Assert.assertEquals(5, minHeap.getMin());
        minHeap.push(30);
        Assert.assertEquals(5, minHeap.getMin());
        minHeap.push(10);
        Assert.assertEquals(5, minHeap.getMin());
        minHeap.push(2);
        Assert.assertEquals(2, minHeap.getMin());
        minHeap.push(2);
        Assert.assertEquals(2, minHeap.getMin());
        minHeap.push(3);
        Assert.assertEquals(2, minHeap.getMin());
        minHeap.push(100);
        Assert.assertEquals(2, minHeap.getMin());
        minHeap.push(-1);
        Assert.assertEquals(-1, minHeap.getMin());
        minHeap.push(9);
        Assert.assertEquals(-1, minHeap.getMin());
        minHeap.push(0);
        Assert.assertEquals(-1, minHeap.getMin());
        minHeap.push(-5);
        Assert.assertEquals(-5, minHeap.getMin());
    }

    @Test
    public void testRemoveMin(){
        MinHeap minHeap = new MinHeap(20);
        minHeap.push(15);
        minHeap.push(5);
        minHeap.push(30);
        minHeap.push(10);
        minHeap.push(2);
        minHeap.push(2);
        minHeap.push(3);
        minHeap.push(100);
        minHeap.push(-1);
        minHeap.push(9);
        minHeap.push(0);
        minHeap.push(-5);
        Assert.assertEquals(-5, minHeap.getMin());
        Assert.assertEquals(-5, minHeap.pop());
        Assert.assertEquals(-1, minHeap.getMin());
        Assert.assertEquals(-1, minHeap.pop());
        Assert.assertEquals(0, minHeap.getMin());
        Assert.assertEquals(0, minHeap.pop());
        Assert.assertEquals(2, minHeap.getMin());
        Assert.assertEquals(2, minHeap.pop());
        Assert.assertEquals(2, minHeap.getMin());
        Assert.assertEquals(2, minHeap.pop());
        Assert.assertEquals(3, minHeap.getMin());
        Assert.assertEquals(3, minHeap.pop());
        Assert.assertEquals(5, minHeap.getMin());
        Assert.assertEquals(5, minHeap.pop());
        Assert.assertEquals(9, minHeap.getMin());
        Assert.assertEquals(9, minHeap.pop());
        Assert.assertEquals(10, minHeap.getMin());
    }
}
