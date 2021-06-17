import com.abhi.list.linkedlist.LinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListUtil {

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode head){
        LinkedListNode slowRun = head;
        LinkedListNode fastRun = head;
        while (fastRun != null && fastRun.next!= null){
            slowRun = slowRun.next;
            fastRun = fastRun.next.next;
            if(slowRun == fastRun){
                return true;
            }
        }
        return false;
    }

    public static LinkedListNode detectCycle(LinkedListNode head) {
        LinkedListNode slowRun = head;
        LinkedListNode fastRun = head;
        while (fastRun != null && fastRun.next!= null){
            slowRun = slowRun.next;
            fastRun = fastRun.next.next;
            if(slowRun == fastRun){
                LinkedListNode slow2 = head;
                while (slow2 != slowRun){
                    slowRun = slowRun.next;
                    slow2 = slow2.next;
                }
                return slowRun;
            }
        }
        return null;
    }


    public static LinkedListNode detectCycleSet(LinkedListNode head) {
        Set<LinkedListNode> set = new HashSet();
        set.add(head);
        LinkedListNode slowRun = head;
        while (slowRun != null && slowRun.next!= null){
            slowRun = slowRun.next;
            if(set.contains(slowRun)){
                return slowRun;
            }
            set.add(slowRun);
        }
        return null;
    }

    public static LinkedListNode insertNodeAtPosition(LinkedListNode head, int data, int position) {
        LinkedListNode current = head;
        int currentPosition = 0;
        while(current!=null && currentPosition<position-1){
            current = current.next;
            currentPosition++;
        }
        if(currentPosition!=position-1){
            throw new RuntimeException();
        }
        insertAtNode(current, data, false);
        return head;
    }

    public static LinkedListNode sortedInsert(LinkedListNode head, int data) {

        if(head == null){
            throw new RuntimeException();
        }

        if(data<=head.value){
            LinkedListNode node = new LinkedListNode(data);
            node.next = head;
            head.prev = node;
            head = node;
            return head;
        }

        LinkedListNode current = head;
        while(current.next != null && current.value<data){
            current = current.next;
        }
        if(current.value<data)
            insertAtNode(current, data, true);
        else
            insertAtNode(current.prev, data, true);
        return head;
    }

    private static LinkedListNode insertAtNode(LinkedListNode nodeAt, int data, boolean isDouble){
        LinkedListNode node = new LinkedListNode(data);
        LinkedListNode next = nodeAt.next;
        nodeAt.next = node;
        node.next = next;
        if(isDouble)
            node.prev = nodeAt;
        return node;
    }

    public static int findMergeNode(LinkedListNode head1, LinkedListNode head2) {
        int size1 = 0;
        int size2 = 0;
        LinkedListNode current1 = head1;
        LinkedListNode current2 = head2;
        while(current1 != null){
            current1 = current1.next;
            size1++;
        }
        while(current2 != null){
            current2 = current2.next;
            size2++;
        }

        int diff = Math.abs(size1-size2);
        current1 = head1;
        current2 = head2;
        while(diff > 0) {
            if (size1 > size2) {//move head1
                current1 = current1.next;
                diff--;
            } else {//move head2
                current2 = current2.next;
                diff--;
            }
        }
        while(current1 != current2){
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1.value;
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode previous = current;
        while(current != null){
            previous  = current;
            current = current.next;
            LinkedListNode next = previous.next;
            previous.next = previous.prev;
            previous.prev = next;
        }
        return previous;
    }
    //1->2->3->4->5
    //1<-2<-3<-4<-5
    public static LinkedListNode reverseFull(LinkedListNode head) {
        if(head == null){
            return head;
        }
        LinkedListNode current = head;
        LinkedListNode previous = null;
        while(current != null){
            LinkedListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    public static String traverseFull(LinkedListNode head) {
        if(head == null){
            return null;
        }
        LinkedListNode current = head;
        StringBuilder builder = new StringBuilder();
        while(head != null){
            builder.append(head.value+"->");
            head = head.next;
        }
        builder.append("null");
        return builder.toString();
    }

//1->2->3->4->5   2 and 4
// 1->4->3->2->5
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        if(left == right || head == null){
            return head;
        }
        if(left == 1){
            return reverseToEnd(head, left, right);
        }
        LinkedListNode current = head;
        LinkedListNode previous = null;
        int count = 1;
        while(current.next != null && count<left){
            previous = current;
            current = current.next;
            count++;
        }
        previous.next = reverseToEnd(current, left, right);
        return head;
    }

    private static LinkedListNode reverseToEnd(LinkedListNode startNode, int left, int right) {
        LinkedListNode current = startNode;
        LinkedListNode previous = null;
        while (current != null && left<=right){
            LinkedListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            left++;
        }
        startNode.next = current;
        return previous;
    }

    public static LinkedListNode removeZeroSumSublists(LinkedListNode head) {
        Stack<LinkedListNode> stack = new Stack<>();
        LinkedListNode current = head;
        int negativeValue = 0;
        while(current != null){
            if(current.value>0) {
                stack.push(current);
            }else{
                negativeValue += current.value;
                while (!stack.isEmpty() && negativeValue<0){
                    if((stack.peek().value + negativeValue) <= 0){
                        negativeValue += stack.pop().value;
                    }else{
                        break;
                    }
                }
            }
            current = current.next;
        }
        if(negativeValue != 0){
            while (!stack.isEmpty() && negativeValue<0){
                if((stack.peek().value + negativeValue) <= 0){
                    negativeValue += stack.pop().value;
                }else{
                    break;
                }
            }
        }
        current = null;
        LinkedListNode next = null;
        while (!stack.isEmpty()){
            if(next == null){
                next = stack.pop();
                next.next = null;
                continue;
            }

            current  = stack.pop();
            current.next = next;
            next = current;
        }
        if(current == null){
            return next;
        }
        return current;
    }

}
