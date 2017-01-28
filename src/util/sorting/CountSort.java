package util.sorting;

import java.util.Arrays;

/**
 * Created by neelabhsingh on 19/12/16.
 */
public class CountSort {
    public static int [] countSort(int [] array){
        int size1 = array.length;
        int [] sortedArray = new int[size1];
        int maxValue = getMax(array);
        int [] A1 = new int[maxValue+1];
        Arrays.fill(A1, 0);
        for(int i=0; i<size1; i++){
            A1[array[i]]+=1;
        }
        for(int i=1; i<=maxValue; i++){
            A1[i]+=A1[i-1];
        }
        for(int i=0; i<size1; i++){
            sortedArray[A1[array[i]]-1] = array[i];
            A1[array[i]]--;
        }
        return sortedArray;
    }
    private static int getMax(int [] array){
        int size = array.length;
        if(size >0){
            int max = array[0];
            for(int i=1; i<size;i++){
                max=Math.max(array[i], max);
            }
            return max;
        }else {

        }
        return 0;
    }
}
