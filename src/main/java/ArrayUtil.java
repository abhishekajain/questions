import java.util.*;

public class ArrayUtil {

    public static int findRepeat(int[] n){
        int i = 1;
        while(i<=n.length){
            int j = 0;
            boolean isSeen = false;
            while (j<n.length){
                if(i==n[j]){
                    if(isSeen){
                        return  i;
                    }
                    isSeen = true;
                }
                j++;
            }
            i++;
        }
        throw new IllegalArgumentException("no duplicate");
    }

    public static int findRepeatBinary(int[] n, int start, int end){
        while(start<end){
            int middle = start + (end-start)/2;
            try{
                return findRepeatBinary(n, start, middle);
            }catch (Exception e){
//              ignore
            }
            try{
                return findRepeatBinary(n, middle+1, end);
            }catch (Exception e){
//              ignore
            }
            int i = start;
            while(i<=middle){
                int j = 0;
                boolean isSeen = false;
                while (j<n.length){
                    if(i==n[j]){
                        if(isSeen){
                            return  i;
                        }
                        isSeen = true;
                    }
                    j++;
                }
                i++;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int findDuplicate(int[] intArray) {

        // find a number that appears more than once ... in O(n) time
        int i = 0;
        int value = intArray[0];
        while(i<intArray.length){
            value = intArray[value-1];
            i++;
        }
        return 0;
    }

    // Complete the largestRectangle function below.
    public static long largestRectangle(int[] h) {
        long[] max = new long[1];
        int i = 0;
        while(i<h.length){
            createRangePair(h, i, max);
            i++;
        }
        return max[0];
    }
    private static void createRangePair(int[] h, int left, long[] max){
        int pairElements = h.length - left;
        int i = 0;
        int lastIndex = pairElements-1;
        while(lastIndex<h.length){
            max[0] = Math.max(calculateRangeRectangleArea(h, i, lastIndex+1), max[0]);
            i++;
            lastIndex++;
        }

    }
    private static long calculateRangeRectangleArea(int[] h, int start, int end){
        int i = start;
        int min = h[i];
        while(i<end){
            min = Math.min(min, h[i++]);
        }
        return min*(end - start);
    }

    public static long largestRectangleOptimized(int[] h) {
        long max = 0;
        int i = 0;
        while(i<h.length){
            int num = h[i];
            int start = i;
            while(start>=0){
                if(h[start]<num){
                    break;
                }
                start--;
            }
            int end = i;
            while(end<h.length){
                if(h[end]<num){
                    break;
                }
                end++;
            }
            max = Math.max(max, (end-start-1)*num);
            i++;
        }
        return max;
    }

    // Complete the riddle function below.
    public static long[] riddle(long[] arr) {
        // complete this function
        long[] result = new long[arr.length];
        int i = 0;
        while(i<arr.length){
            result[i] = maxOfWindow(arr, i+1);
            i++;
        }
        return result;
    }
    private static long maxOfWindow(long[] arr, int windowSize){
        int i = 0;
        long max = Integer.MIN_VALUE;
        while(i<=arr.length-windowSize){
            max = Math.max(minOfWindow(arr, i, windowSize), max);
            i++;
        }
        return max;
    }
    private static long minOfWindow(long[] arr, int start, int windowSize){
        long min = arr[start];
        int i = start;
        while(i<(start+windowSize)){
            min = Math.min(min, arr[i++]);
        }
        return min;
    }

    //{1,2,100,0,-100,2,-100,120,1,-1} {7,8}
    public static int[] findMaxSumRange(int[] nums){
        return null;
    }
// 2.1.0.3 2
//    2.0.0.0 2
//    2.0.0.1 2.0
    public static int compareVersion(String v1, String v2){
        return 0;
    }

    public static int[] whatFlavors2(int[] cost, int money) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        int i = 0;
        while(i<cost.length){
            if(map.containsKey(cost[i])){
                map.get(cost[i]).add(i+1);
            }else{
                TreeSet<Integer> list = new TreeSet<>();
                list.add(i+1);
                map.put(cost[i], list);
            }
            i++;
        }

        for(Integer key: map.keySet()){
            if(key == (money-key)){
                if(map.get(key).size()>=2){
                    int[] flavours = new int[2];
                    flavours[0] = map.get(key).pollFirst();
                    flavours[1] = map.get(key).pollFirst();
                    return flavours;
                }
            }
            else if (map.containsKey((money-key))){
                int[] flavours = new int[2];
                int first = map.get(key).pollFirst();
                int second = map.get((money-key)).pollFirst();
                if(first<second){
                    flavours[0] = first;
                    flavours[1] = second;
                }else{
                    flavours[0] = second;
                    flavours[1] = first;
                }
                return flavours;
            }
        }
        return null;
    }

    public static int[] whatFlavors(int[] cost, int money) {
        int first = 0;
        while(first<cost.length){
            int second = first+1;
            while(second<cost.length){
                if(cost[second] == (money-cost[first])){
                    int[] flavours = new int[2];
                    flavours[0] = first+1;
                    flavours[1] = second+1;
                    return flavours;
                }
                second++;
            }
            first++;
        }
        return null;
    }
    // 8243 --> 8324
    // find replacement swap and sort remaining number in decreasing order
    public static String getNextMax(String number){
        char [] chars = number.toCharArray();
        int[] result = findReplaceIndex(chars);
        if(result == null){
            return number;
        }
        swap(chars, result[0], result[1]);
        int minIndex = Math.min(result[0], result[1]);
        sort(chars, minIndex+1);
        return new String(chars);
    }

    private static int[] findReplaceIndex(char[] chars){
        int[] result = new int[2];
        int i = chars.length-1;
        int j = i-1;
        while(i>0){
            j = i-1;
            while(j>=0) {
                if (chars[i] > chars[j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
                j--;
            }
            i--;
        }
        return null;
    }

    private static void swap(char[] chars, int fromIndex, int toIndex){
        char temp = chars[fromIndex];
        chars[fromIndex] = chars[toIndex];
        chars[toIndex] = temp;
    }
    // fromIndex inclusive
    public static void sort(char[] chars, int fromIndex){
        char[] temp = new char[chars.length-fromIndex];
        System.arraycopy(chars, fromIndex,  temp, 0, temp.length);
        mergeSort(temp);
        System.arraycopy(temp, 0, chars, fromIndex, temp.length);
    }

    //merge sort char as int values
    public static void mergeSort(char[] chars){
        mergeSort(chars, 0, chars.length-1);
    }

    public static void mergeSort(char[] chars, int fromIndex, int toIndex){
        if(fromIndex>=toIndex){
            return;
        }
        int middle = fromIndex + (toIndex-fromIndex)/2;
        mergeSort(chars, fromIndex, middle);
        mergeSort(chars, middle+1, toIndex);
        merge(chars, fromIndex, middle, toIndex);
    }

    public static void merge(char[] chars, int left, int middle, int right){
        char[] tempLeft = new char[middle-left+1];
        char[] tempRight = new char[right-middle];
        System.arraycopy(chars, left,  tempLeft, 0, tempLeft.length);
        System.arraycopy(chars, middle+1,  tempRight, 0, tempRight.length);

        int lstart = 0;
        int rstart = 0;
        int index = left;
        while (lstart<tempLeft.length && rstart<tempRight.length){
            if(tempLeft[lstart]<tempRight[rstart]){
                chars[index++] = tempLeft[lstart++];
            }else{
                chars[index++] = tempRight[rstart++];
            }
        }
        if(lstart<tempLeft.length){
            System.arraycopy(tempLeft, lstart, chars, index, tempLeft.length-lstart);
        }
        if(rstart<tempRight.length) {
            System.arraycopy(tempRight, rstart, chars, index, tempRight.length-rstart);
        }
    }
//    Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
//    We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
//    4,2,3,5,9
    public static boolean checkPossibility(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        int current = nums[0];
        boolean foundDecrese = false;
        int i = 1;
        while(i<nums.length){
            int next = nums[i++];
            if(next<current){
                if(foundDecrese){
                    return false;
                }
                foundDecrese = true;
            }
            current = next;
        }
        return true;
    }

//    Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
//    subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

//            Example 1:
//    Input: [23, 2, 4, 6, 7],  k=6
//    Output: True
//    Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
//    Example 2:
//    Input: [23, 2, 6, 4, 7],  k=6
//    Output: True
//    Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
//        23+2+6+4+7 2+6+4+7 6+4+7 4+7
    public static boolean checkSubarraySum(int[] nums, int k) {
        int i = 0;
        while(i<nums.length-1){
            int j = i+1;
            int sum = nums[i];
            while(j<nums.length){
                sum += nums[j];
                if(sum%k==0){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public static List<List<Integer>> mergeInterval(List<List<Integer>> input, List<Integer> newInterval){
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> interval:input){
            int start = interval.get(0);
            int end = interval.get(1);

            int nstart = newInterval.get(0);
            int nend = newInterval.get(1);
            if(nend<start){//outside
                result.add(newInterval);
                newInterval = interval;
            }
            else if(nstart>end) {//outside
                result.add(interval);
            }else{
                newInterval = merge(interval, newInterval);
            }
        }
        result.add(newInterval);
        return result;
    }

    private static List<Integer> merge(List<Integer> interval1, List<Integer> interval2){
        int start = interval1.get(0);
        int end = interval1.get(1);

        int nstart = interval2.get(0);
        int nend = interval2.get(1);

         if(nstart>=start && nend<=end){//inside
            return interval1;
        }else if(nstart<=start && nend>=end){//bigger
            return interval2;
        }else if(nend<=end){
            List<Integer> result = new ArrayList<>();
            result.add(nstart);
            result.add(end);
            return result;
        }else {
            List<Integer> result = new ArrayList<>();
            result.add(start);
            result.add(nend);
            return result;
        }
    }
}
