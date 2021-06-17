import org.junit.Assert;
import org.junit.Test;

public class LinkedListUtilTest {

    @Test
    public void testContainsCycle(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
//        0->1->2->1...
        node0.next = node1;
        node1.next = node2;
        node2.next = node1;

        Assert.assertTrue(LinkedListUtil.containsCycle(node0));
    }

    @Test
    public void testNotContainsCycle(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
//        0->1->2->1...
        node0.next = node1;
        node1.next = node2;
        node2.next = null;

        Assert.assertFalse(LinkedListUtil.containsCycle(node0));
    }

    @Test
    public void testdetectCycle(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
//        0->1->2->1...
        node0.next = node1;
        node1.next = node2;
        node2.next = node1;

        Assert.assertEquals(node1, LinkedListUtil.detectCycle(node0));
    }

    @Test
    public void testdetectCycleSet(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
//        0->1->2->1...
        node0.next = node1;
        node1.next = node2;
        node2.next = node1;

        Assert.assertEquals(node1, LinkedListUtil.detectCycleSet(node0));
    }

    @Test
    public void testdetectCycleNull(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
//        0->1->2->1...
        node0.next = node1;
        node1.next = node2;
        node2.next = null;

        Assert.assertNull(LinkedListUtil.detectCycle(node0));
    }

    @Test
    public void testfindMergeNode(){
        LinkedListUtil.LinkedListNode node0 = new LinkedListUtil.LinkedListNode(0);
        LinkedListUtil.LinkedListNode node1 = new LinkedListUtil.LinkedListNode(1);
        LinkedListUtil.LinkedListNode node2 = new LinkedListUtil.LinkedListNode(2);
        node0.next = node1;
        node1.next = node2;
        node2.next = null;
    }

    @Test
    public void testReverseFull(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(1);
        node.next = new LinkedListUtil.LinkedListNode(2);
        node.next.next = new LinkedListUtil.LinkedListNode(3);
        node.next.next.next = new LinkedListUtil.LinkedListNode(4);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(5);
        node.next.next.next.next.next = new LinkedListUtil.LinkedListNode(6);
        Assert.assertEquals("6->5->4->3->2->1->null", LinkedListUtil.traverseFull(LinkedListUtil.reverseFull(node)));
    }

    @Test
    public void testReverseBetween(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(1);
        node.next = new LinkedListUtil.LinkedListNode(2);
        node.next.next = new LinkedListUtil.LinkedListNode(3);
        node.next.next.next = new LinkedListUtil.LinkedListNode(4);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(5);
        Assert.assertEquals("1->4->3->2->5->null", LinkedListUtil.traverseFull(LinkedListUtil.reverseBetween(node, 2, 4)));

    }

    @Test
    public void testReverseBetweenStartEnd(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(3);
        node.next = new LinkedListUtil.LinkedListNode(5);

        Assert.assertEquals("5->3->null", LinkedListUtil.traverseFull(LinkedListUtil.reverseBetween(node, 1, 2)));

    }

    @Test
    public void testRemoveZeroSumSublists(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(1);
        node.next = new LinkedListUtil.LinkedListNode(2);
        node.next.next = new LinkedListUtil.LinkedListNode(-3);
        node.next.next.next = new LinkedListUtil.LinkedListNode(3);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(1);
        Assert.assertEquals("3->1->null", LinkedListUtil.traverseFull(LinkedListUtil.removeZeroSumSublists(node)));

    }

    @Test
    public void testRemoveZeroSumSublists2(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(1);
        node.next = new LinkedListUtil.LinkedListNode(2);
        node.next.next = new LinkedListUtil.LinkedListNode(3);
        node.next.next.next = new LinkedListUtil.LinkedListNode(-3);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(4);
        Assert.assertEquals("1->2->4->null", LinkedListUtil.traverseFull(LinkedListUtil.removeZeroSumSublists(node)));

    }
    @Test
    public void testRemoveZeroSumSublists3(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(1);
        node.next = new LinkedListUtil.LinkedListNode(2);
        node.next.next = new LinkedListUtil.LinkedListNode(3);
        node.next.next.next = new LinkedListUtil.LinkedListNode(-3);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(-2);
        Assert.assertEquals("1->null", LinkedListUtil.traverseFull(LinkedListUtil.removeZeroSumSublists(node)));

    }

    @Test
    public void testRemoveZeroSumSublists4(){
        LinkedListUtil.LinkedListNode node = new LinkedListUtil.LinkedListNode(5);
        node.next = new LinkedListUtil.LinkedListNode(-3);
        node.next.next = new LinkedListUtil.LinkedListNode(-4);
        node.next.next.next = new LinkedListUtil.LinkedListNode(1);
        node.next.next.next.next = new LinkedListUtil.LinkedListNode(6);
        node.next.next.next.next.next = new LinkedListUtil.LinkedListNode(-2);
        node.next.next.next.next.next.next = new LinkedListUtil.LinkedListNode(-5);

        Assert.assertEquals("5->-2->-5->null", LinkedListUtil.traverseFull(LinkedListUtil.removeZeroSumSublists(node)));

    }
}
