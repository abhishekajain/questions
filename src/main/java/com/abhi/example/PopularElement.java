package com.abhi.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PopularElement {
	
	public static void main(String[] args){
		
		int[] input = {1,2,1,1,3,4,3,7,8,5,6,7,1,2,3,5,0,7,7,7,9,2,1,1,1,4,5,6};
		PopularCollection pC = new PopularCollection();
		for(int i:input){
			pC.addElement(i);
		}	
		System.out.println(pC.getPopular().getValue());
		System.out.println(pC.getPopular().getCount());
	}
	
	static class PopularCollection{
		List<Element> list; 
		PopularCollection(){
			this.list = new ArrayList<Element>();
		}
		
		public void addElement(int i){			
			Element e = new Element(i);		
			int index = this.list.indexOf(e);
			if(index != -1){
				this.list.get(index).increasePopularity();
			}else{
				this.list.add(e);
			}
		}
		
		public Element getPopular() {
			Collections.sort(this.list);
			return this.list.get(0);
		}
	}
	
	static class Element implements Comparable<Element>{
		private int value;
		private int count;
		
		Element(int value){
			this.value = value;
			this.count = 1;
		}

		public int getValue() {
			return value;
		}

		public int getCount() {
			return count;
		}
		
		public void increasePopularity() {
			synchronized (this) {
				this.count++;
			}			
		}
		
		@Override
		public int compareTo(Element o) {
//			if(this.value == o.value){
				return o.count - this.count;
//			}else{
//				return o.value - this.value;
//			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			Element other = (Element) obj;
			if (value != other.value)
				return false;
			return true;
		}	
	}

}
