package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 28/12/16.
 */
public class SortedRotatedArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] array = br.readLine().split(" ");
        int n = array.length;
        int [] arrayInt = new int[n];
        for(int i=0; i<n; i++){
            arrayInt[i] = Integer.parseInt(array[i]);
        }
        int target = Integer.parseInt(br.readLine());
        System.out.println(search(arrayInt, target));
    }
    public static int search(int[] nums, int target) {
        return searchUtil(nums, target, 0, nums.length-1);
    }
    public static int searchUtil(int [] nums, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[start] <= nums[mid]){
            if(target >= nums[start] && target <=nums[mid]){
                return searchUtil(nums, target, start, mid-1);
            }
            return searchUtil(nums, target, mid+1, end);
        }
        if(target >=nums[mid] && target<=nums[end]){
            return searchUtil(nums, target, mid+1, end);
        }
        return searchUtil(nums, target, start, mid-1);
    }
}
