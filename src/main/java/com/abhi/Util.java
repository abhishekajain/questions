package com.abhi;

public class Util {
	
	public static void printArray(long... objects){
		System.out.print("[");
		for(int i=0;i<objects.length;i++){			
			System.out.print(objects[i]);
			if(i!=(objects.length-1)){
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

}
