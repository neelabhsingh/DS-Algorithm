package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/01/17.
 */
/**
Given an unsorted array of non-negative integers, find a continous subarray which adds to a given number.
*/
public class SubArrayWithGivenSum {
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
            Index newIndex = subArrayWithGivenSum(numbers, sum);
            if(newIndex.getStart()!=-1){
                System.out.println(newIndex.getStart()+" "+newIndex.getEnd());
            }else{
                System.out.println(-1);
            }
        }
    }
    public static Index subArrayWithGivenSum(int [] array, int sum){
        int size = array.length;
        int totalSum =0;
        int start=0;
        for(int i=0; i<size; i++){
            totalSum+=array[i];
            while (start<i && totalSum>sum){
                totalSum-=array[start];
                start++;
            }
            if(totalSum==sum){
                return new Index(start+1, i+1);
            }
        }
        return new Index(-1, -1);
    }
}
class Index{
    private int start;
    private int end;

    public Index(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}