package Array;

/**
 * Created by neelabhsingh on 20/01/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Design an algorithm to find all pairs of Integers within array which sum to a specified value.
*/

public class FindAllPairToSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strValue = br.readLine().split(" ");
        int [] array = new int[strValue.length];
        int i=0;
        for(String str: strValue){
            array[i] = Integer.parseInt(str);
            i++;
        }
        int sum = Integer.parseInt(br.readLine());
        printPairs(array, sum);
    }
    public static void printPairs(int [] array, int sum){
        int start=0;
        int end = array.length-1;
        Arrays.sort(array);
        while (start<end){
            if(array[start]+ array[end]==sum){
                System.out.println(array[start] +" "+ array[end]);
                start++;
                end--;
            }else if((array[start]+ array[end])<sum){
                start++;
            }else {
                end--;
            }
        }
    }
}
