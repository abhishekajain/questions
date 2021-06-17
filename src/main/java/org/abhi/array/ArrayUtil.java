package org.abhi.array;

public class ArrayUtil {

    // 0 exit 1 entry
    public static int findBusiestPeriod(int[][] data) {
        // your code goes here
        int runningSum = 0;
        int maxPeriodTime = 0;
        int maxSum = 0;

        int i = 0;

        int start = 0;

        while(i<data.length){
            if(data[i][0] == start){
                if(data[i][2] == 1){
                    runningSum += data[i][1];
                }else{
                    runningSum -= data[i][1];
                }
                i++;
                continue;
            }else{
                start = data[i][0];
                if(runningSum>maxSum){
                    maxSum = runningSum;
                    maxPeriodTime = data[i][0];
                }
                if(data[i][2] == 1){
                    runningSum += data[i][1];
                }else{
                    runningSum -= data[i][1];
                }
                i++;
            }
        }
        return maxPeriodTime;
    }

    public static int[] arrayOfArrayProducts(int[] arr) {
        // your code goes here
        int[] leftArrProduct = productLeft(arr);
        int[] rightArrProduct = productRight(arr);

        int[] result = new int[arr.length];
        int count = 1;
        result[0] = rightArrProduct[1];
        result[arr.length-1] = leftArrProduct[arr.length-2];
        while(count<arr.length-1){
            result[count] = leftArrProduct[count-1]*rightArrProduct[count+1];
            count++;
        }
        return result;
    }

    private static int[] productLeft(int[] arr){
        int[] result = new int[arr.length];
        result[0] = arr[0];
        int count = 1;
        while(count<arr.length){
            result[count] = arr[count]*result[count-1];
            count++;
        }
        return result;
    }

    private static int[] productRight(int[] arr){
        int[] result = new int[arr.length];
        result[arr.length-1] = arr[arr.length-1];
        int count = arr.length-2;
        while(0<count){
            result[count] = arr[count]*result[count+1];
            count--;
        }
        return result;
    }
}
