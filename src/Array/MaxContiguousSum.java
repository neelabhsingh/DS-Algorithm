package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/12/16.
 */
public class MaxContiguousSum {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] str = br.readLine().split(" ");
        int [] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<n;i++){
            currSum+=array[i];
            if(currSum<0){
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);
    }
}
