package com.abhi.example;

public class ArrayOfArray {

	/**
	 * 
	 * inputArray[] = [-3, [7,4,[8], 10],[4,[6,[9]],12], 13]; 
	 * output
	 * - -3
	 * -- 7
	 * -- 4
	 * --- 8
	 * -- 10
	 * -- 4
	 * --- 6
	 * ---- 9
	 * -- 12
	 * - 13
	 */
	public static void main(String[] args) {
		MutliDimArray mutliDimArray = new MutliDimArray(4);
		mutliDimArray.add(-3, 0);
		
		MutliDimArray mutliDimArray2 = new MutliDimArray(4);
		mutliDimArray2.add(7, 0);
		mutliDimArray2.add(4, 1);
		MutliDimArray mutliDimArray21 = new MutliDimArray(1);
		mutliDimArray21.add(8, 0);
		mutliDimArray2.add(mutliDimArray21, 2);
		mutliDimArray2.add(10, 3);
		mutliDimArray.add(mutliDimArray2, 1);
		
		MutliDimArray mutliDimArray3 = new MutliDimArray(3);
		mutliDimArray3.add(4, 0);
		MutliDimArray mutliDimArray31 = new MutliDimArray(3);
		mutliDimArray31.add(6, 0);
		mutliDimArray31.add(12, 3);
		mutliDimArray3.add(mutliDimArray31, 1);
		mutliDimArray3.add(12, 2);

		mutliDimArray.add(mutliDimArray3, 2);
		
		mutliDimArray.add(13, 3);
		
		mutliDimArray.print(1);
	}
	
	static class MutliDimArray{
		private Object[] objectArr;
		private int size;
		MutliDimArray(int size){
			this.size = size;
			this.objectArr = new Object[size];			
		}
		
		public boolean add(Object obj, int index){
			if(index<0 || (index+1)>this.size){
				return false;
			}
			this.objectArr[index] = obj;
			return true;
		}
		
		public void print(int index){
			for(Object obj:this.objectArr){
				if(obj instanceof MutliDimArray){
					((MutliDimArray)obj).print((index+1));
				}else{
					for(int i=0;i<index;i++){
						System.out.print("-");
					}
					System.out.println(obj);
				}
			}
		}
	}

}
