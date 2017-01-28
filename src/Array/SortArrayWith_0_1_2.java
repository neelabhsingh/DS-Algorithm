package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 20/01/17.
 */
public class SortArrayWith_0_1_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int size = str.length;
        int [] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = Integer.parseInt(str[i]);
        }
        segregation_0_1_2(numbers);
        for(int value: numbers){
            System.out.print(value +" ");
        }
    }
    public static void segregation_0_1_2(int [] array){
        int start =0;
        int end = array.length-1;
        int mid =0;
        while (mid< end){
            switch (array[mid]){
                case 0:
                    int temp = array[mid];
                    array[mid] = array[start];
                    array[start] = temp;
                    mid++;
                    start++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp1 = array[mid];
                    array[mid] = array[end];
                    array[end] = temp1;
                    end--;
                    break;
            }
        }
    }
}
