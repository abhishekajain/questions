package com.abhi.tree.binary.heap;

public class Item implements Comparable<Item> {

	int key;
	int value;
	int frequency = 1;
	int timestamp;
	int index;

	@Override
	public int compareTo(Item o) {
		if (this.frequency == o.frequency) {
			return this.timestamp - o.timestamp;
		}
		return this.frequency - o.frequency;
	}

	@Override
	public String toString() {
		return "Item [key=" + key + ", value=" + value + ", frequency=" + frequency + ", timestamp=" + timestamp
				+ ", index=" + index + "]";
	}

}
