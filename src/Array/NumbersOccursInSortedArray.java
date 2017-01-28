package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 23/01/17.
 */
public class NumbersOccursInSortedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] array = br.readLine().split(" ");
        int size =array.length;
        int [] numbers = new int[size];
        int i=0;
        for(String value: array){
            numbers[i] = Integer.parseInt(value);
            i++;
        }
        int x = Integer.parseInt(br.readLine());
        System.out.println(countOccurrences(numbers, x));
    }
    public static int countOccurrences(int [] numbers, int x){
        int size = numbers.length;
        int start =0;
        int end = numbers.length-1;
        int index1 = getFirstIndex(numbers, start, end, x);
        if(index1!=-1){
            int index2 = getLastIndex(numbers, start, end, x, size);
            return index2- index1+1;
        }else {
            return index1;
        }
    }
    public static int getFirstIndex(int [] numbers, int start, int end, int x){
        if(start<=end){
            int mid = start + (end-start)/2;
            if((mid==0 || numbers[mid-1]< numbers[mid])&&(numbers[mid]==x)){
                return mid;
            }
            if(numbers[mid] >= x){ // This equality is very important.
                return getFirstIndex(numbers, start, mid-1, x);
            }else {
                return getFirstIndex(numbers, mid+1, end, x);
            }
        }
        return -1;
    }
    public static int getLastIndex(int [] numbers, int start, int end, int x, int size){
        if(start<=end){
            int mid = start + (end-start)/2;
            if((mid==size-1 || numbers[mid+1]> numbers[mid])&&(numbers[mid]==x)){
                return mid;
            }
            if(numbers[mid]>x){
                return getLastIndex(numbers, start, mid-1, x, size);
            }else{
                return getLastIndex(numbers, mid+1, end, x, size);
            }
        }
        return -1;
    }
}
