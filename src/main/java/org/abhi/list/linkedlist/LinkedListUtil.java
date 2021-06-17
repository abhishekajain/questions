package org.abhi.list.linkedlist;

import com.abhi.datastructure.linkedlist.LinkedList;

public class LinkedListUtil {

    static class SinglyLinkedListNode{
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        SinglyLinkedListNode current1 = head1;
        SinglyLinkedListNode current2 = head2;
        SinglyLinkedListNode head = null;
        if(current1.data<=current2.data){
            head = current1;
            current1 = current1.next;
        }else{
            head = current2;
            current2 = current2.next;
        }
        SinglyLinkedListNode current = head;
        while (current1 != null && current2 != null){
            if(current1.data<=current2.data){
                current.next = current1;
                current1 = current1.next;
            }else{
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }

        copySinglyLinkedList(current1, current);
        copySinglyLinkedList(current2, current);

        return head;

    }

    private static void copySinglyLinkedList(SinglyLinkedListNode from, SinglyLinkedListNode to) {
        while (from != null) {
            to.next = from;
            from = from.next;
            to = to.next;
        }
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode resultHead = new SinglyLinkedListNode(llist.data);

        SinglyLinkedListNode current = llist.next;
        SinglyLinkedListNode resultCurrent = resultHead;
        while (current != null){
            if(current.data != resultCurrent.data){
                resultCurrent.next = new SinglyLinkedListNode(current.data);
                resultCurrent = resultCurrent.next;
            }
            current = current.next;
        }

        return resultHead;
    }

    public static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode result = null;
        int size = 0;
        SinglyLinkedListNode current = llist;

        while(current != null){
            if(size == positionFromTail){
                if(result == null){
                    result = llist;
                }else {
                    result = result.next;
                }
            }else{
                size++;
            }
            current = current.next;

        }
        return result.data;
    }
}
