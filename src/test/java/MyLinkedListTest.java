import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testAddAtHead(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        Assert.assertEquals(1, linkedList.get(0));
        linkedList.addAtHead(2);
        Assert.assertEquals(2, linkedList.get(0));
        linkedList.addAtHead(3);
        Assert.assertEquals(3, linkedList.get(0));
    }

    @Test
    public void testAddAtTail(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtTail(1);
        Assert.assertEquals(1, linkedList.get(0));
        linkedList.addAtTail(2);
        Assert.assertEquals(1, linkedList.get(0));
        linkedList.addAtTail(3);
        Assert.assertEquals(1, linkedList.get(0));
    }

    @Test
    public void testGetAtIndex(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtHead(2);
        linkedList.addAtHead(3);
        Assert.assertEquals(1, linkedList.get(2));
        linkedList.addAtHead(4);
        Assert.assertEquals(4, linkedList.get(0));
        Assert.assertEquals(3, linkedList.get(1));
        Assert.assertEquals(2, linkedList.get(2));
        Assert.assertEquals(1, linkedList.get(3));
    }

    @Test
    public void testAddAtIndex(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);//0,1
        linkedList.addAtHead(2);//1,2
        linkedList.addAtHead(3);//2,3
        linkedList.addAtIndex(3,4);
        Assert.assertEquals(4, linkedList.get(3));
        linkedList.addAtIndex(3,5);
        Assert.assertEquals(5, linkedList.get(3));
        linkedList.addAtIndex(3,6);
        Assert.assertEquals(6, linkedList.get(3));
    }

    @Test
    public void testDeleteAtIndex(){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);//0,1
        linkedList.addAtHead(2);//1,2
        linkedList.addAtHead(3);//2,3
        linkedList.addAtIndex(3,4);
        linkedList.addAtIndex(3,5);
        linkedList.addAtIndex(3,6);
        linkedList.deleteAtIndex(3);
        Assert.assertEquals(5, linkedList.get(3));
    }
}
