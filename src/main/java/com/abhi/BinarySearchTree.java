package com.abhi;

public class BinarySearchTree {
	
	private Element head;
	
	BinarySearchTree(Element head){
		this.head = head;		
	}
	
	public int deapth(Element e1, Element e2){
		return 1;
	}
	
	static class Element{
		int value;
		Element right;
		Element left;
		
		Element(int value){
			this.value = value;
			this.right = null;
			this.left = null;
		}
		
		void add(Element e){
			
		}
	}

}
