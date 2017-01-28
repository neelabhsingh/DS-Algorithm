package Array;

/**
 * Created by neelabhsingh on 26/01/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 Find the largest rectangular area possible in a given histogram where the largest rectangle can
 be made of a number of contiguous bars. For simplicity, assume that all bars have same width and
 the width is 1 unit.
 */

public class MaximumAreaInHistogram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0) {
            int size = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] numbers = new int[size];
            for(int i=0; i<size; i++){
                numbers[i]= Integer.parseInt(str[i]);
            }
        }
    }
    public static int getMaxHistogramArea(int [] array){
        return -1;
    }
}
