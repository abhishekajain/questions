package com.abhi.datastructure.linkedlist;


//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
class MergeLinkList {

	public static void main(String[] args){

		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(4);


		ListNode n21 = new ListNode(1);
		ListNode n22 = new ListNode(3);
		ListNode n23 = new ListNode(4);

		n11.next=n12;
		n12.next=n13;

		n21.next=n22;
		n22.next=n23;

//		print(mergeTwoLists(n11, n21));
//		print(mergeTwoLists(null, n21));
		print(mergeTwoLists(n11, null));
		print(mergeTwoLists(null, null));




		//print(n11);
		//print(n21);

	}

	public static void print(ListNode l1) {
		while(l1 != null){
			System.out.println(l1.val+"-->");
			l1 = l1.next;
		}
	}

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode head = null;
    	ListNode c1 = null;  
    	if(l1 == null && l2 == null) {
    		return null;
    	}
    	if(l1!=null && l2==null) {
    		return l1;
    	}
    	if(l1==null && l2!=null) {
    		return l2;
    	}
    	
    	while(l1 != null && l2 != null) {
    		if(l1.val<=l2.val) {
    			if(head == null) {
    				head = new ListNode(l1.val);
    				c1=head;
        			l1=l1.next;

    				continue;
    			}
    			c1.next =new ListNode(l1.val);
    			l1=l1.next;
    			c1=c1.next;
    		}else {
    			if(head == null) {
    				head = new ListNode(l2.val);
    				c1 = head;
        			l2=l2.next;

    				continue;
    			}
    			c1.next = new ListNode(l2.val);
    			l2=l2.next;
    			c1=c1.next;

    		}
    	}
    	if(l1 != null) {
    		c1.next =l1;
    	}else if(l2!=null) {
    		c1.next =l2;
    	}
    	return head;
    }
    
    public static ListNode mergeTwoListsBetter(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode head=node;
        
        while (l1!=null&&l2!=null)
        {
            if(l1.val>l2.val)
            {
               node.next=l2;
               l2=l2.next;
            }else
            {
               node.next=l1;
               l1=l1.next;
            }
           node=node.next;
        }
        
            if(l1==null)
               node.next=l2;
            if(l2==null)
               node.next=l1;

        return head.next;
    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}