package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 26/01/17.
 */
/**
 *Given an array A[] of n numbers and another number x, determine whether or not there exist
 *three elements in A[] whose sum is exactly x.
 Expected time complexity is O(n^2).
 * */
public class TripletSumInArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            String [] str = br.readLine().split(" ");
            int size = Integer.parseInt(str[0]);
            int sum = Integer.parseInt(str[1]);
            String []strArray = br.readLine().split(" ");
            int [] numbers = new int[size];
            for(int i=0; i<size;i++){
                numbers[i] = Integer.parseInt(strArray[i]);
            }
            System.out.println(isTripletExist(numbers, sum));
        }
    }
    public static int isTripletExist(int [] array, int sum){
        Arrays.sort(array);
        int size = array.length;
        for(int i=0;i<size-2; i++){
            int l=i+1;
            int r=size-1;
            while (l<r){
                if(array[i]+array[l]+array[r]==sum){
                    return 1;
                }else if(array[i]+array[l]+array[r]<sum){
                    l++;
                }else if(array[i]+array[l]+array[r]>sum){
                    r--;
                }
            }
        }
        return 0;
    }
}
