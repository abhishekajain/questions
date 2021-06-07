package com.abhi.datastructure.linkedlist;

import java.util.Stack;

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		System.out.println(14%10);
		
		ListNode n11 = new ListNode(2);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(3);


		ListNode n21 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		ListNode n23 = new ListNode(4);

		n11.next=n12;
		n12.next=n13;

		n21.next=n22;
		n22.next=n23;
		
		print(addTwoNumbers(n11, n21));
		
		
	}
	
	public static void print(ListNode l1) {
		while(l1 != null){
			System.out.println(l1.val+"-->");
			l1 = l1.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		Stack<Integer> s1 = new Stack<Integer>();
//		while(l1 != null) {
//			s1.push(l1.val);
//			l1 = l1.next;
//		}
//		Stack<Integer> s2 = new Stack<Integer>();
//		while(l2 != null) {
//			s2.push(l2.val);
//			l2 = l2.next;
//		}
		
		ListNode head = new ListNode(0);
		ListNode sum = head;
		int remendr = 0;
		Stack<Integer> s3 = new Stack<Integer>();

		while(l1!=null || l2!=null) {
			int s1v = 0;
			int s2v = 0;
			if(l1!=null) {
				s1v = l1.val;
				l1=l1.next;
			}
			
			if(l2!=null) {
				s2v = l2.val;
				l2=l2.next;
			}
			Integer sumOfS1S2 =s1v+s2v+remendr;
			remendr = sumOfS1S2/10;
			if(remendr == 1) {
				sum.val = sumOfS1S2-10;
				s3.push(sumOfS1S2-10);
			}else {
				sum.val = sumOfS1S2;
				s3.push(sumOfS1S2);
				remendr = 0;
			}
			
			if(l1!=null || l2!=null) {
				sum.next = new ListNode(0);
				sum = sum.next;
			}
		}

		if(remendr == 1) {
			sum.next = new ListNode(remendr);
		}
		
		return head;
	}
	
	static ListNode addTwoLists(ListNode first, ListNode second) {
		ListNode res = null; // res is head node of the resultant list
		ListNode prev = null;
		ListNode temp = null;
        int carry = 0, sum;
 
        while (first != null || second != null) //while both lists exist
        {
            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.val : 0)
                    + (second != null ? second.val : 0);
 
            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;
 
            // update sum if it is greater than 10
            sum = sum % 10;
 
            // Create a new node with sum as data
            temp = new ListNode(sum);
 
            // if this is the first node then set it as head of
            // the resultant list
            if (res == null) {
                res = temp;
            } else // If this is not the first node then connect it to the rest.
            {
                prev.next = temp;
            }
 
            // Set prev for next insertion
            prev = temp;
 
            // Move first and second pointers to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
 
        // return head of the resultant list
        return res;
    }

	   public static ListNode addTwoNumbersbetter(ListNode l1, ListNode l2) {
	        if(l1 == null)
	            return l2;
	        if(l2 == null)
	            return l1;
	        
	        ListNode dummy = new ListNode(0);
	        ListNode curr = dummy;
	        int sum = 0;
	        int carry = 0;
	        while(l1 != null || l2 != null) {
	            int l1Val = l1 == null ? 0 : l1.val;
	            int l2Val = l2 == null ? 0 : l2.val;
	            sum = carry + l1Val + l2Val;
	            curr.next = new ListNode(sum % 10);
	            carry = sum / 10;
	            
	            if(l1 != null)
	                l1 = l1.next;
	            if(l2 != null)
	                l2 = l2.next;
	            curr = curr.next;
	        }
	        if(carry != 0) {
	            curr.next = new ListNode(carry);
	        }
	        return dummy.next;        
	    }
	   
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
