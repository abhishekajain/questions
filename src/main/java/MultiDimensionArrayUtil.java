import java.util.*;

public class MultiDimensionArrayUtil {
    // it is a NXN array
//    method modifies input array
    public static void rotateArrayClockwise(int[][] input){
        int start = 0;
        int end = input.length-1;
        //col++ till it reaches end
        //row++ till it reaches end dont change col
        // col-- to start dont change row
        //row-- to start dont change col
        //move start++ and end-- do this to make half the size
        while(start<end) {
            int row = start;
            int col = start;
            int previous = input[row][col];
            while (col < end) {
                previous = swap(input, row, ++col, previous);
            }
            while (row < end) {
                previous = swap(input, ++row, col, previous);
            }
            while (col > start) {
                previous = swap(input, row, --col, previous);
            }
            while (row > start) {
                previous = swap(input, --row, col, previous);
            }
            start++;
            end--;
        }
    }

    public static int swap(int[][] input, int i, int j, int previous){
        int temp = input[i][j];
        input[i][j] = previous;
        return temp;
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int result = 0;

        return result;
    }

    // Complete the freqQuery function below.
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> values = new HashMap<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (List<Integer> query : queries){
            operation(result, values, query, frequency);
        }
        return result;
    }
    private static void increaseFreq(Map<Integer, Integer> frequency, int value){
        if(frequency.containsKey(value)){
            int freq = frequency.get(value);
            frequency.put(value, (freq+1));
        }else{
            frequency.put(value, 1);
        }
    }

    private static void decreaseFreq(Map<Integer, Integer> frequency, int value){
        if(frequency.containsKey(value)){
            int count = frequency.get(value);
            if(count == 1){
                frequency.remove(value);
            }else {
                frequency.put(value, (count - 1));
            }
        }
    }
    private static void operation(List<Integer> result, Map<Integer, Integer> values, List<Integer> operation, Map<Integer, Integer> frequency){
        //1 add 2 delete
        int operator = operation.get(0);
        int value  = operation.get(1);
        switch (operator){
            case 1:
                if(values.containsKey(value)){
                    int count = values.get(value);
                    values.put(value, (count+1));
                }else{
                    values.put(value, 1);
                }
                break;
            case 2:
                if(values.containsKey(value)){
                    int count = values.get(value);
                    if(count == 1){
                        values.remove(value);
                    }else {
                        values.put(value, (count - 1));
                    }
                }
                break;
            case 3:
                //find
                Set<Integer> set = new HashSet(values.values());
                if(set.contains(value)){
                    result.add(1);
                }else{
                    result.add(0);
                }
                break;
            default:
                break;
        }
    }


}
