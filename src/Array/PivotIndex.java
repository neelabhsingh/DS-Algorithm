package Array;

/**
 * Created by neelabhsingh on 18/01/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* Return the pivot index of the given array of numbers. The pivot index is the index where the sum of the numbers on
* the left is equal to the sum of the numbers on the right. Input Array {1,2,3,4,0,6}
*/
/**
 * https://www.careercup.com/question?id=5695352763056128
* */
public class PivotIndex {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] array = br.readLine().split(" ");
        int size = array.length;
        int [] nums = new int[size];
        for(int i=0; i<size; i++){
            nums[i] = Integer.parseInt(array[i]);
        }
        System.out.println(getPivotIndex(nums));
    }
    public static int getPivotIndex(int [] array){
        int size = array.length;
        int leftSide = 0;
        int rightSide = 0;
        for(int i=0; i<size; i++){
            rightSide+= array[i];
        }
        for(int i=0; i<size; i++){
            rightSide-=array[i];
            if(rightSide== leftSide){
                return i;
            }
            leftSide+=array[i];
        }
        return -1;
    }
}
