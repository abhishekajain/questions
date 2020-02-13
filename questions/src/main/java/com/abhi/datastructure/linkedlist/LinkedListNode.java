package com.abhi.datastructure.linkedlist;

public class LinkedListNode {

	public int value;
	public LinkedListNode next;

	public LinkedListNode(int value) {
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
