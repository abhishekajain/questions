package com.abhi.tree.binary.heap;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. 
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 */

class LRUCache {

	int size = 0;
	int capacity = 0;
	Map<Integer, Node> cache = null;

	Node front;
	Node rear;

	public LRUCache(int capacity) {
		this.cache = new HashMap<Integer, Node>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (this.cache.containsKey(key)) {
			Node node = this.cache.get(key);
			this.addToFront(node);
			return node.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (this.cache.containsKey(key)) {
			Node node = this.cache.get(key);
			node.value = value;
			this.addToFront(node);
		} else {
			if (this.isFull()) {
				Node node = this.removeFromRear();
				this.cache.remove(node.key);
				this.size--;
			}
			Node node = new Node();
			node.key = key;
			node.value = value;
			this.addToFront(node);
			this.cache.put(key, node);
			this.size++;
		}
	}

	public boolean isFull() {
		if (this.size == this.capacity) {
			return true;
		}
		return false;
	}

	private void addToFront(Node node) {
		if (this.front == node) {
			return;
		}
		if (this.front == null) {
			this.front = node;
			this.rear = node;
			return;
		}
		
		if (node.previous != null) {
			node.previous.next = node.next;
		}
		if (node.next != null) {
			node.next.previous = node.previous;
		}
		node.next = this.front;
		if (node == this.rear) {
			this.rear = node.previous;
		}
		node.previous = null;
		this.front.previous = node;
		this.front = node;
	}

	private Node removeFromRear() {
		if (this.front == this.rear) {
			Node temp = this.front;
			this.front = null;
			this.rear = null;
			return temp;
		}
		Node temp = this.rear;
		this.rear = this.rear.previous;
		this.rear.next = null;
		return temp;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);

		cache.put(1, 1); // 1
		cache.put(2, 2); // 2-1
		cache.put(3, 3); // 3-2-1
		cache.put(4, 4); // 4-3-2

		cache.get(4); // returns 4 4-3-2
		cache.get(3); // returns 3 3-4-2
		cache.get(2); // returns 2 2-3-4
		cache.get(1); // returns -1

		cache.put(5, 5); // 5-2-3

		cache.get(1); // returns -1
		cache.get(2); // returns 2 2-5-3
		cache.get(3); // returns 3 -1 3-2-5
		cache.get(4); // returns -1 4
		cache.get(5); // returns 5 5 5-3-2

	}

}
