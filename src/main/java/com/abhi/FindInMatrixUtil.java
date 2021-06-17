package com.abhi;

public class FindInMatrixUtil {

    static int[][] matrix = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 0, 1, 0}
    };

//    return 0 mean not known, return 1 mean known
    static int isKnown(int i, int j){
        return matrix[i][j];
    }

    static int findCelebrity(int n){
        int[] arri = new int[4];
        int[] arrj = new int[4];
        int i = 0;
        while(i<n){
            int j = 0;
            while(j<n){
                if(i!=j) {
                    System.out.println("i-->" + i + "<--j-->" + j + "<--result-->" + isKnown(i, j));
                    arri[i] = arri[i] + isKnown(i, j);
                    arrj[j] = arrj[j] + isKnown(i, j);
                }
                j++;
            }
            i++;
        }
        System.out.println(arri);
        System.out.println(arrj);

        int k = 0;

        while(k<n){
            if(arri[k] == 0 && arrj[k] == (n-1)){
                return (k+1);
            }
            k++;
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(findCelebrity(4));
    }
}
