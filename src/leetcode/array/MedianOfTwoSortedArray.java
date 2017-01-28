package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 08/01/17.
 */
public class MedianOfTwoSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str1 = br.readLine().split(" ");
        int size1 = str1.length;
        int [] array1 = new int[size1];
        for(int i=0; i<size1; i++){
            array1[i] = Integer.parseInt(str1[i]);
        }

        String [] str2 = br.readLine().split(" ");
        int size2 = str2.length;
        int [] array2 = new int[size2];
        for(int i=0; i<size2; i++){
            array2[i] = Integer.parseInt(str2[i]);
        }
        System.out.println(medianOfTwoArray(array1, array2));
    }
    public static double medianOfTwoArray(int [] array1, int [] array2){
        return findMedianSortedArrays(array1, array1.length, array2, array2.length);
    }
    public static double findMedianSortedArrays(int [] array1, int m, int [] array2, int n){
        int mid1 = m/2;
        int mid2 = n/2;
        int k;
        if(array1[mid1]<= array2[mid2]){

        }
        return -1;
    }
}











