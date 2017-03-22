package com.abhi;

public class BinarySearchTree {
	
	private Element head;
	
	BinarySearchTree(Element head){
		this.head = head;		
	}
	
	BinarySearchTree(){
		this.head = null;		
	}
	
	public int deapth(Element e1, Element e2){
		return 1;
	}
	
	public boolean find(int elementValue){
		Element current = head;
		while(current!=null){
			if(current.value==elementValue){
				return true;
			}else if(current.value>elementValue){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}		
	
	
	public void insert(int elementValue){
		Element newNode = new Element(elementValue);
		if(head==null){
			head = newNode;
			return;
		}
		Element current = head;
		Element parent = null;
		while(true){
			parent = current;
			if(elementValue<current.value){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void display(Element root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.value);
			display(root.right);
		}
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
	}
}
