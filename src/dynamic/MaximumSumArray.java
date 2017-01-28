package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 15/01/17.
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSumArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] array = br.readLine().split(" ");
        int size = array.length;
        int [] num = new int[size];

        for(int i=0; i<size; i++){
            num[i] = Integer.parseInt(array[i]);
        }
        System.out.println(maximumSumArray(num));
    }
    public static int maximumSumArray(int [] array){
        int size = array.length;
        if(size==0){
            return 0;
        }
        int maxOverAll = array[0];
        int localMax = array[0];
        for(int i=1; i<size;i++){
            localMax = Math.max(array[i], localMax+ array[i]);
            maxOverAll = Math.max(maxOverAll, localMax);
        }
        return maxOverAll;
    }
}
