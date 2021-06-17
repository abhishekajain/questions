import java.util.HashSet;
import java.util.Set;

class QueryOfQueries {

//    store even inedexs
    Set<Integer> evenIndexs = null;
//    sum of even indexes at the time
    int sum = 0;

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int i = 0;
        //empty result array
        int[] result = new int[queries.length];
        while(i<queries.length){
            //add value of query to index of A
            int index =  queries[i][1];
            int value = queries[i][0];
            result[i] = this.sumOfEven(A, value, index);
            A[index] = A[index] + index;
            i++;
        }
        return result;
    }

    //find sum of the even values from int[]
    private int sumOfEven(int[] A, Integer val, Integer index){
//        if evenindexs are null initialize and calculate even sum for first time
        if(this.evenIndexs == null){
            A[index] += val;
            evenIndexs = new HashSet<Integer>();
            int i = 0;
            while(i<A.length){
                if(A[i]%2 == 0){
                    sum += A[i];
                    evenIndexs.add(i);
                }
                i++;
            }
        }else{
            if(val%2 == 0){//if new valus is even
                if(evenIndexs.contains(index)){//new query index is in the even indexs, add value to even sum
                    sum += val;
                }
            }else{//if new value is odd
                if(evenIndexs.contains(index)){//index is in the even indexes remove this index and remove from sum
                    evenIndexs.remove(index);
                    sum -= A[index];
                }else{//else add to even indexs and add i and value to sum
                    evenIndexs.add(index);
                    sum += (A[index] + val);
                }
            }
        }
        return sum;
    }
}