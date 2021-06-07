package com.abhi;

import java.util.*;

public class ArrayUtil {

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> stack = new ArrayList<Integer>();
        Integer max = Integer.MIN_VALUE;

        for(String operation:operations){
            char charAtZrero = operation.charAt(0);
            if(charAtZrero == '1'){//add
                Integer value = Integer.valueOf(operation.substring(2));
                if(value.compareTo(max)>0){
                    max = value;
                }
                stack.add(value);
            }else if ( charAtZrero == '2'){//delete
                Integer deleteElm = stack.remove(stack.size()-1);
                if(deleteElm.equals(max)){
                    max = Integer.MIN_VALUE;
                    for(Integer num:stack){
                        if(num.compareTo(max)>0){
                            max = num;
                        }
                    }
                }
            }else if (charAtZrero == '3'){//getmax
                result.add(max);
            }
        }
        return result;

    }


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        int aIndex = 0;
        int bIndex = 0;
        int runningSum = 0;
        int result = 0;
        while(aIndex<a.size() && bIndex<b.size()){
            if(a.get(aIndex).compareTo(b.get(bIndex))>0){
                runningSum += b.get(bIndex);
                bIndex++;
            }else{
                runningSum += a.get(aIndex);
                aIndex++;
            }
            if(runningSum>maxSum){
                return result;
            }
            result++;
        }

        while(aIndex<a.size()){
            runningSum += a.get(aIndex);
            aIndex++;
            if(runningSum>maxSum){
                return result;
            }
            result++;
        }

        while(bIndex<b.size()){
            runningSum += b.get(bIndex);
            bIndex++;
            if(runningSum>maxSum){
                return result;
            }
            result++;
        }

        return result;
    }

    public static int twoStacksS(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> sumA = convertListToSumMap(a, maxSum);
        List<Integer> sumB = convertListToSumMap(b, maxSum);

        int result = 0;
        int i = sumA.size()-1;
        while(i>=0){
            int j = sumB.size()-1;
            int runningSumA = sumA.get(i);
            while (j>=0){
                int runningSumB = sumB.get(j);
                if((runningSumA+runningSumB)<=maxSum && result<(i+j+2)){
                    result = i+j+2;
                }
                j--;
            }
            i--;
        }

        i = sumA.size()-1;
        while(i>=0){
            if(sumA.get(i)<=maxSum && result<(i+1)){
                result = i+1;
            }
            i--;
        }
        i = sumB.size()-1;
        while(i>=0){
            if(sumB.get(i)<=maxSum && result<(i+1)){
                result = i+1;
            }
            i--;
        }
        return result;
    }

    private static List<Integer> convertListToSumMap(List<Integer> a, int maxSum){
        List<Integer> sumA = new ArrayList<>();
        int runningSum = 0;
        int i = 0;
        while(i<a.size()){
            int num = a.get(i);
            runningSum += num;
            if(runningSum>maxSum){
                break;
            }
            sumA.add(runningSum);
            i++;
        }
        return sumA;
    }
// 30 to 100 .. 30,000 entries
//    {65, 68, 66, 69, 70, 74, 73, 74, 76} {1, 2, 1, 1, 1, 3, 1 , 1, 0}
    public static int[] warmerDays(int[] temps){
        int[] result = new int[temps.length];
        int i = 0;
        while (i<temps.length){
            int index = findNextMaxIndex(temps, i);
            result[i] = index-i;
            i++;
        }
        return result;
    }

    private static int findNextMaxIndex(int[] temps, int index){
        int temp = index;
        int value = temps[index++];
        while(index<temps.length){
            if(temps[index]>value){
                return index;
            }
            index++;
        }
        return temp;
    }

    public static int[] dailyTemperatures(int[] T){
        int n = T.length;

        // To store the answer
        int[] daysOfWait = new int[n];
        Arrays.fill(daysOfWait, -1);

        Stack<Integer> s = new Stack<>();

        // Traverse all the temperatures
        for(int i = 0; i < n; i++)
        {

            // Check if current index is the
            // next warmer temperature of
            // any previous indexes
            while (!s.isEmpty() && T[s.peek()] < T[i])
            {
                daysOfWait[s.peek()] = i - s.peek();

                // Pop the element
                s.pop();
            }

            // Push the current index
            s.push(i);
        }
        return daysOfWait;
}

    static class Pair {
        int min;
        int max;
    }

    public static Pair getMinMax(int[] arr) {
        int len = arr.length;
        return getMinMax(arr, 0, len-1);
    }

    public static Pair getMinMax(int[] arr, int start, int end) {
        if(end==start){
            Pair pair = new Pair();
            pair.max = arr[start];
            pair.min = arr[start];
            return pair;
        }
        if(end-start == 1){
            Pair pair = new Pair();
            pair.max = Math.max(arr[start], arr[end]);
            pair.min = Math.min(arr[start], arr[end]);
            return pair;
        }
        int middle = start + (end-start)/2;
        Pair pairL = getMinMax(arr, start, middle);
        Pair pairR = getMinMax(arr, middle+1, end);
        Pair pair = new Pair();
        pair.max = Math.max(pairL.max, pairR.max);
        pair.min = Math.min(pairL.min, pairR.min);
        return pair;
    }
}
