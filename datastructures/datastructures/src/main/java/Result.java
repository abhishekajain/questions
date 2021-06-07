import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
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
                break;
            }
            i--;
        }
        i = sumB.size()-1;
        while(i>=0){
            if(sumB.get(i)<=maxSum && result<(i+1)){
                result = i+1;
                break;
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

}