package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 26/01/17.
 */
public class MinimumDiffPair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int size = str.length;
        int [] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        System.out.println(minDifference(array));
    }
    public static int minDifference(int [] array){
        Arrays.sort(array);
        int minDiff = Integer.MAX_VALUE;
        int size = array.length;
        for(int i=1; i<size; i++){
            minDiff = Math.min(minDiff, array[i]- array[i-1]);
        }
        return minDiff;
    }
}
