import java.util.Arrays;

public class SortUtil {

    private static void swap(int i, int j, int[] input){
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }

    static void mergeSort(int[] input) {
        mergeS(input,0,input.length-1);
    }

    static void mergeS(int[] input, int start, int end) {
        if (start < end) {
            int m = (start + end)/2;
//            int m = start + (end - start)/2;

//            from start inclusive to middle point inclusive
            mergeS(input, start, m);
//            from middle+1 to end
            mergeS(input, m + 1, end);
            // Merge start to middle inclusive and from m+1 to end inclusive
            merge(input, start, m, end);
        }
    }

    static void qucikSort(int[] input){
        qucikSort(input, 0, input.length-1);
    }

    private static void qucikSort(int[] input, int low, int high){
        if (high>low){
            int pivot = findPivot(input, low, high);
            qucikSort(input, low, pivot-1);
            qucikSort(input, pivot+1, high);
        }
    }

    private static int findPivot(int[] input, int low, int high){

        int[] temp = new int[high-low+1];

        int pivot = input[high];

        int i = 0;
        int l = low;
        int j = temp.length-1;

        while (low<high){
            if(pivot>input[low]){
                temp[i] = input[low];
                i++;
            }else{
                temp[j] = input[low];
                j--;
            }
            low++;
        }
        temp[i] = pivot;
        copy(input, temp, l);
        return l+i;
    }

    private static void copy(int[] input, int[] merged, int startIndex){
        for(int k=0;k<merged.length;k++){
            input[startIndex+k] = merged[k];
        }
    }
//    startIndex to middleIndex middle inclusive in first arr
//    middleIndex+1 to endIndex middle exclusive in second arr
    static void merge(int[] input, int start, int middle, int end) {
        if(start >= end){
            return;
        }

        int[] startArr = Arrays.copyOfRange(input, start, middle+1);
        int[] endArr = Arrays.copyOfRange(input, middle+1, end+1);

        int i = 0;
        int j = 0;

        while(i<startArr.length && j<endArr.length){
            if(startArr[i]<=endArr[j]){
                input[start++] = startArr[i++];
            }else{
                input[start++] = endArr[j++];
            }
        }

        while (i<startArr.length){
            input[start++] = startArr[i++];
        }

        while (j<endArr.length){
            input[start++] = endArr[j++];
        }

    }

    static void bubbleSort(int[] input){
        int len = input.length;
        if(len < 2){
            return;
        }
        int i = len-1;
        while(i>0){
            int k = 0;
            while (k<i){
                if(input[k]>input[k+1]){
                    swap(k+1, k, input);
                }
                k++;
            }
            i--;
        }
    }
}
