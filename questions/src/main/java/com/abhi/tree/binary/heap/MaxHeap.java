package com.abhi.tree.binary.heap;

import java.util.Arrays;

public class MaxHeap {
	
	private int size = 0;
	private int[] items;
	
	public MaxHeap(int capacity) {
		this.items = new int[capacity];
	}
	
	public boolean isFull() {
		return this.items.length == this.size;
	}
	
	public int peek() {
		return this.items[0];
	}
	
	public int getParentIndex(int index) {
		return (index-1)/2;
	}
	
	public int getChild(int index, boolean left) {
		return 2*index + (left?1:2);
	}
	
	public int getLeftChild(int index) {
		int right = 2*index+1;
		if(right < this.size) {
			return right;
		}
		return -1;
	}
	
	public int getRightChild(int index) {
		int left = 2*index+2;
		if(left < this.size) {
			return left;
		}
		return -1;
	}
	
	public void add(int item) {
		if(this.isFull()) {
			throw new IndexOutOfBoundsException("Heap is full.");
		}
		this.items[this.size] = item;
		this.fixHeapAbove(this.size++);
	}
	
	private void fixHeapAbove(int index) {
		int item = this.items[index];
		int parentIndex = this.getParentIndex(index);
		while(index > 0 && item > this.items[parentIndex]) {
			this.items[index] = this.items[parentIndex];
			index = parentIndex;
			parentIndex = this.getParentIndex(index);
		}
		this.items[index] = item;
	}
	
	private void fixHeapBelow(int index) {
		int leftChildIndex = this.getLeftChild(index);
		int rightChildIndex = this.getRightChild(index);	
		int value = this.items[index];
		
		while(!(leftChildIndex == -1 && rightChildIndex == -1)) {
			if (rightChildIndex == -1) {
				if (value < this.items[leftChildIndex]) {
					this.items[index] = this.items[leftChildIndex];
					this.items[leftChildIndex] = value;
				}
				break;
			}else {			
				int compare = this.items[leftChildIndex] > this.items[rightChildIndex]?this.items[leftChildIndex]:this.items[rightChildIndex];
				if (value < compare) {
					this.items[index] = compare;
					if(compare == this.items[leftChildIndex]) {
						index = leftChildIndex;
					}else {
						index = rightChildIndex;
					}	
				}else {
					break;
				}
			}
			leftChildIndex = this.getLeftChild(index);
			rightChildIndex = this.getRightChild(index);	
		}	
		this.items[index] = value;
	}
	
	public int deleteItem(int item) {
		int index = this.find(item);
		if(index != -1) {
			int replacementValue = this.items[--this.size];
			this.items[index] = replacementValue;
			int parentIndex = this.getParentIndex(index);
			if(parentIndex>=0 && this.items[parentIndex]<item) {
				this.fixHeapAbove(index);
			}else {
				this.fixHeapBelow(index, this.size-1);
			}
 		}
		return item;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int deleteItemAtIndex(int index) {
		if(index < 0 || index > this.size-1) {
			throw new IndexOutOfBoundsException("Index outside heap.");
		}
		
		int item = this.items[index];
//		reduce size, replace with last item
		this.items[index] = this.items[--this.size];
//		now looks up and below to find which side to look
//		if parent item is less, fix heap above
		if(this.items[index] > this.items[this.getParentIndex(index)]) {
			this.fixHeapAbove(index);
		}else {
			this.fixHeapBelow(index, this.size-1);
		}		
		return item;
	}
	
	private void fixHeapBelow(int index, int lastHeapIndex) {
		int indexValue = this.items[index];
		int rightChildIndex = this.getRightChild(index);
		int leftChildIndex = this.getLeftChild(index);
		
		if(leftChildIndex > lastHeapIndex) {
			rightChildIndex = -1;
			leftChildIndex = -1;
		}else if(rightChildIndex > lastHeapIndex) {
			rightChildIndex = -1;
		}
		
		while(leftChildIndex != -1) {
			if(leftChildIndex != -1 && rightChildIndex != -1) {
				int leftChild = this.items[leftChildIndex];
				int rightChild = this.items[rightChildIndex];
				int compareValue = leftChild > rightChild ? leftChild:rightChild;
				if(indexValue < compareValue) {
					int compareIndex = leftChild == compareValue ? leftChildIndex : rightChildIndex;
					this.items[index] = compareValue;
					index = compareIndex;		
					rightChildIndex = this.getRightChild(index);
					leftChildIndex = this.getLeftChild(index);
					if(leftChildIndex > lastHeapIndex) {
						rightChildIndex = -1;
						leftChildIndex = -1;
					}else if(rightChildIndex > lastHeapIndex) {
						rightChildIndex = -1;
					}
				}else {
					break;
				}
			}else {
				int compareValue = this.items[leftChildIndex];
				if(indexValue < compareValue) {
					this.items[index] = compareValue;
					index = leftChildIndex;	
				}
				break;
			}
		}
		this.items[index] = indexValue;
	}
	
	public void sort() {
		int lastHeapIndex = this.size -1;
		while(lastHeapIndex > 0) {
			int temp = this.items[lastHeapIndex];
			this.items[lastHeapIndex] = this.items[0];
			this.items[0] = temp;
			this.fixHeapBelow(0, --lastHeapIndex);
		}	
	}
	
	private int find(int item) {
		if(this.size != 0) {			
			for(int i=0; i<this.size; i++) {
				if(item == this.items[i]) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void print() {
		System.out.println(this.size);
		System.out.println(Arrays.toString(this.items));
	}
	
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(100);
		maxHeap.add(4);
		maxHeap.add(22);
		maxHeap.add(14);
		maxHeap.add(3);
		maxHeap.add(19);
		maxHeap.add(18);
		maxHeap.add(12);
		maxHeap.add(15);
		maxHeap.add(25);
		maxHeap.add(9);
		maxHeap.print();
		maxHeap.deleteItem(22);
		maxHeap.print();
		maxHeap.deleteItem(9);
		maxHeap.print();
		maxHeap.deleteItemAtIndex(0);
		maxHeap.print();
		maxHeap.sort();
		maxHeap.print();

	}
//	[22, 19, 18, 15, 4, 14, 12, 3]
//	0    1    2   3   4  5   6  7
//	         22[0]
//	   19[1]   		18[2]
// 15[3] 4[4] 	14[5]    12[6]
// 3[7]
}
