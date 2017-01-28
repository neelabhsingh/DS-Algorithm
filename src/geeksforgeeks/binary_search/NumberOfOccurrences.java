package geeksforgeeks.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 12/01/17.
 */
//http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
public class NumberOfOccurrences {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strings = br.readLine().split(" ");
        int size = strings.length;
        int [] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(strings[i]);
        }
        int k = Integer.parseInt(br.readLine());
        System.out.println(numberOfOccurrences(array, k));
    }
    public static int numberOfOccurrences(int [] array, int k){
        int size = array.length;
        int index1 = getFirstIndexOccurrence(array, 0, size-1, k);
        int index2 = getLastIndexOccurrence(array, 0, size-1, k);
        if(index1>=0 && index2>=0){
            return index2-index1+1;
        }else {
            return -1;
        }
    }
    public static int getFirstIndexOccurrence(int [] array, int start, int end, int k){
        if(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid]==k &&(mid==0 || array[mid-1] < array[mid])){
                return mid;
            }
            if(array[mid]>= k){ // Here equal is very important steps. This is handling the case when we are between of k occurrence.
                end = mid-1;
            }else {
                start = mid+1;
            }
            return getFirstIndexOccurrence(array, start, end, k);
        }
        return -1;
    }
    public static int getLastIndexOccurrence(int [] array, int start, int end, int k){
        if(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid]==k &&(mid==array.length-1 || array[mid] < array[mid+1])){
                return mid;
            }
            if(array[mid]> k){
                end = mid-1;
            }else {
                start = mid+1; //This is handling the case when we are between of k occurrence.
            }
            return getLastIndexOccurrence(array, start, end, k);
        }
        return -1;
    }
}
