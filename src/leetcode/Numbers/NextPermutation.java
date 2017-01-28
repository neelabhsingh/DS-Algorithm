package leetcode.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 23/01/17.
 */
public class NextPermutation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] numStr = br.readLine().split(" ");
        int size = numStr.length;
        int [] num = new int[size];
        for(int i=0; i<size; i++){
            num[i]= Integer.parseInt(numStr[i]);
        }
        nextPermutation(num);
        for(int val: num){
            System.out.print(val+" ");
        }
    }
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length==0 || nums.length==1){
            return;
        }
        int size = nums.length;
        int i= size-2;
        while (i>0 && nums[i]>= nums[i+1]){
            i--;
        }
        if(i==0 && nums[i]>nums[i+1]){
            Arrays.sort(nums, 0, size);
            return;
        }
        int j = i+1;
        int justLargest = j;
        while (j<size){
            if(nums[justLargest] > nums[j] && nums[j]> nums[i]){
                justLargest = j;
            }
            j++;
        }
        int temp = nums[i];
        nums[i] = nums[justLargest];
        nums[justLargest]= temp;
        Arrays.sort(nums, i+1, size);
    }
}
