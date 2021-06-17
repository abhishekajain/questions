package com.abhi.list.linkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class LinkedListNodeProblems {

	public static class LinkedListNode {

		public int value;
		public LinkedListNode next;

		public LinkedListNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value + "";
		}
	}

	public static int findDuplicate(int[] intArray) {

		// find a number that appears more than once ... in O(n) time

		return 0;
	}

	// tests

	@Test
	public void justTheRepeatedNumberTest() {
		final int[] numbers = { 1, 1 };
		final int expected = 1;
		final int actual = findDuplicate(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void shortArrayTest() {
		final int[] numbers = { 1, 2, 3, 2 };
		final int expected = 2;
		final int actual = findDuplicate(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int[] numbers = { 1, 2, 5, 5, 5, 5 };
		final int expected = 5;
		final int actual = findDuplicate(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] numbers = { 4, 1, 4, 8, 3, 2, 7, 6, 5 };
		final int expected = 4;
		final int actual = findDuplicate(numbers);
		assertEquals(expected, actual);
	}

	public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

		// return the kth to last node in the linked list

		LinkedListNode result = head;

		int count = 0;

		while (head != null) {
			if (count < k) {
				count++;
			} else {
				result = result.next;
			}
			head = head.next;
		}

		if (k == 0 || count < k) {
			throw new IllegalArgumentException();
		}
		return result;
	}

	// tests

	@Test
	public void firstToLastNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 1;
		LinkedListNode head = listNodes[0];
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test
	public void secondToLastNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 2;
		LinkedListNode head = listNodes[0];
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test
	public void firstNodeTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 4;
		final LinkedListNode actual = kthToLastNode(k, listNodes[0]);
		final LinkedListNode expected = listNodes[listNodes.length - k];
		assertSame(expected, actual);
	}

	@Test(expected = Exception.class)
	public void kIsGreaterThanLinkedListLengthTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 5;
		kthToLastNode(k, listNodes[0]);
	}

	@Test(expected = Exception.class)
	public void kIsZeroTest() {
		final LinkedListNode[] listNodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final int k = 0;
		kthToLastNode(k, listNodes[0]);
	}

	public static void deleteNode(LinkedListNode nodeToDelete) {

		// delete the input node from the linked list

		LinkedListNode nextNode = nodeToDelete.next;
		if (nextNode != null) {
			nodeToDelete.next = nextNode.next;
			nodeToDelete.value = nextNode.value;
		} else {
			throw new IllegalArgumentException("Can't delete last node from singly liked list");
		}

	}

	public static boolean containsCycle(LinkedListNode firstNode) {

		// check if the linked list contains a cycle

		if (firstNode == null || firstNode.next == null) {
			return false;
		}

		LinkedListNode slowRun = firstNode;
		LinkedListNode fastRun = firstNode;
		while (fastRun != null && fastRun.next != null) {
			slowRun = slowRun.next;
			fastRun = fastRun.next.next;
			if (slowRun == fastRun) {
				return true;
			}
		}

		return false;
	}

// tests
	@Test
	public void linkedListWithNoCycleTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		final boolean result = containsCycle(nodes[0]);
		assertFalse(result);
	}

	@Test
	public void cycleLoopsToBeginningTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4 });
		nodes[3].next = nodes[0];
		final boolean result = containsCycle(nodes[0]);
		assertTrue(result);
	}

	@Test
	public void cycleLoopsToMiddleTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4, 5 });
		nodes[4].next = nodes[2];
		final boolean result = containsCycle(nodes[0]);
		assertTrue(result);
	}

	@Test
	public void twoNodeCycleAtEndTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4, 5 });
		nodes[4].next = nodes[3];
		final boolean result = containsCycle(nodes[0]);
		assertTrue(result);
	}

	@Test
	public void emptyListTest() {
		final boolean result = containsCycle(null);
		assertFalse(result);
	}

	@Test
	public void oneElementLinkedListNoCycleTest() {
		final LinkedListNode node = new LinkedListNode(1);
		final boolean result = containsCycle(node);
		assertFalse(result);
	}

	@Test
	public void oneElementLinkedListCycleTest() {
		final LinkedListNode node = new LinkedListNode(1);
		node.next = node;
		final boolean result = containsCycle(node);
		assertTrue(result);
	}

	private static LinkedListNode[] valuesToLinkedListNodes(int[] values) {
		final LinkedListNode[] nodes = new LinkedListNode[values.length];
		for (int i = 0; i < values.length; ++i) {
			nodes[i] = new LinkedListNode(values[i]);
			if (i > 0) {
				nodes[i - 1].next = nodes[i];
			}
		}
		return nodes;
	}

	public static LinkedListNode reverse(LinkedListNode headOfList) {

		// reverse the linked list in place
		LinkedListNode current = headOfList;
		LinkedListNode previous = null;
		while (current != null) {
			LinkedListNode next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	// tests

	@Test
	public void shortLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void longLinkedListTest() {
		final LinkedListNode[] nodes = valuesToLinkedListNodes(new int[] { 1, 2, 3, 4, 5, 6 });
		final LinkedListNode result = reverse(nodes[0]);
		assertTrue(isListReversed(result, nodes));
	}

	@Test
	public void oneElementLinkedListTest() {
		final LinkedListNode node = new LinkedListNode(1);
		final LinkedListNode result = reverse(node);
		assertSame(node, result);
	}

	@Test
	public void emptyLinkedListTest() {
		final LinkedListNode result = reverse(null);
		assertNull(result);
	}

	private static boolean isListReversed(LinkedListNode list, LinkedListNode[] originalNodes) {
		int i = originalNodes.length - 1;
		while (list != null && i >= 0) {
			if (originalNodes[i] != list) {
				return false;
			}
			list = list.next;
			i--;
		}
		return list == null && i == -1;
	}

	// tests

	@Test
	public void nodeAtBeginningTest() {
		LinkedListNode head = new LinkedListNode(1);
		appendToList(head, 2);
		appendToList(head, 3);
		appendToList(head, 4);

		deleteNode(head);

		LinkedListNode node = head;
		assertEquals(2, node.value);

		node = node.next;
		assertEquals(3, node.value);

		node = node.next;
		assertEquals(4, node.value);

		assertNull(node.next);
	}

	@Test
	public void nodeInTheMiddleTest() {
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode nodeToDelete = appendToList(head, 2);
		appendToList(head, 3);
		appendToList(head, 4);

		deleteNode(nodeToDelete);

		LinkedListNode node = head;
		assertEquals(1, node.value);

		node = node.next;
		assertEquals(3, node.value);

		node = node.next;
		assertEquals(4, node.value);

		assertNull(node.next);
	}

	@Test(expected = Exception.class)
	public void nodeAtTheEndTest() {
		LinkedListNode head = new LinkedListNode(1);
		appendToList(head, 2);
		appendToList(head, 3);
		LinkedListNode nodeToDelete = appendToList(head, 4);

		deleteNode(nodeToDelete);
	}

	@Test(expected = Exception.class)
	public void oneNodeListTest() {
		LinkedListNode head = new LinkedListNode(1);
		deleteNode(head);
	}

	private static LinkedListNode appendToList(final LinkedListNode head, int value) {
		LinkedListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkedListNode(value);
		return current.next;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(LinkedListNodeProblems.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("All tests passed.");
		}
	}
}