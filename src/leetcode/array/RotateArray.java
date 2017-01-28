package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 25/01/17.
 */
public class RotateArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int n = str.length;
        int [] array = new int[n];
        for(int i=0; i<n ;i++){
            array[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(br.readLine());
        rotate(array, k);
    }
    public static void rotate(int [] nums, int k){
        int size = nums.length;
        k = k%size;
        if(k==0){
            return;
        }
        boolean rolatedLeft = true;

    }
}
