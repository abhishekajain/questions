package com.abhi.datastructure;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class LinkedList {
	
	static class LinkedListNode{
		public int value;
		public LinkedListNode next;
		
		public LinkedListNode(int value){
			this.value = value;
			this.next = null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.value);
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LinkedListNode other = (LinkedListNode) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value != other.value)
				return false;
			return true;
		}		
		
	}
	
	public LinkedListNode head;//firstNode
	
	public static boolean containsCycle(LinkedListNode head){
		Set<LinkedListNode> set = new HashSet<LinkedListNode>();
		
		while(head != null){
			set.add(head);
			head = head.next;
			if(set.contains(head)){
				return true;
			}
		}
		return false;
	}
	
	public static int size(LinkedListNode head){
		int size = 0;
		while(head != null && size != Integer.MAX_VALUE){
			size++;
			head = head.next;
		}
		return size;
	}
	
	public static void print(LinkedListNode head){
		if(head == null){
			System.out.println("end");
			return;
		}
		if(head != null){
			System.out.println(head.value);
			System.out.println(head.next);
			print(head.next);
		}
	}
	
	@Test
	public void testContainsCycle(){
		LinkedListNode head = new LinkedListNode(0);
		head.next = new LinkedListNode(1);
		head.next.next = new LinkedListNode(2);
		print(head);
		Assert.assertEquals(3, size(head));
		Assert.assertFalse(containsCycle(head));
		head.next.next.next = head.next;
//		print(head);

		Assert.assertTrue(containsCycle(head));
		Assert.assertEquals(Integer.MAX_VALUE, size(head));
	}

}
