package com.abhi.datastructure.arrary;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayUtilNew {
	
    public static int superEggDrop(int K, int N) {
        int devide = N/K;
        int reminder = N%K;
        return devide;
    }
    
    private static int oneEggDropHelper(int totalFloor, int currentFloor) {
    	return Math.max(currentFloor-1, totalFloor-currentFloor-1);
    }
    
    @Test
    public void testSuperEggDrop() {
    	System.out.println(superEggDrop(1, 2));
    	System.out.println(superEggDrop(2, 6));
    	System.out.println(superEggDrop(3, 14));
    	System.out.println(superEggDrop(2, 1));
    }
    
    
    public static int findMinDifference(List<String> timePoints) { 
        
        boolean[] values = new boolean[1440];
        
        for(String time : timePoints){
            int mins = calculatMinutes(time);
            if(values[mins]){
                return 0;
            }
            values[mins] = true;
        }
        
        int diff = Integer.MAX_VALUE;
        int previous = 0;
        int firstTrue = -1;
        for(int i=1; i<1440; i++){
            if(values[previous]){
            	if(firstTrue == -1) {
            		firstTrue = previous;
            	}
                if(values[i]){
                    diff = Math.min(diff, (i-previous));
                    previous = i; 
                }                
            }else{
                previous = i;    
            }                
        }
        diff = Math.min(diff, (1440-previous+firstTrue));
        return diff;
    }
    
    private static int calculateDiff(int min1, int min2){
        int diff = Math.abs(min1 - min2);
        if(diff > 720){
            return 1440-diff;
        }
        return diff;
    }
    
    private static int calculatMinutes(String time){
        String[] times = time.split(":");
        return Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
    }    
    
    @Test
    public void testFindMinDifference() {
    	List<String> list = new ArrayList<String>();
    	list.add("05:31");
    	list.add("22:08");
    	list.add("00:35");
    	System.out.println(findMinDifference(list));
    }

}
