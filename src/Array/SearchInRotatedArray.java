package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 28/01/17.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc  = Integer.parseInt(br.readLine());
        while (tc-->0){
            int N =Integer.parseInt(br.readLine());
            String [] strings = br.readLine().split(" ");
            int [] array = new int[N];
            for(int i=0; i<N;i++){
                array[i] = Integer.parseInt(strings[i]);
            }
            int key = Integer.parseInt(br.readLine());
            int index =  searchElementInRotatedArray(array, key);
            System.out.println(index);
        }
    }
    public static int searchElementInRotatedArray(int []array, int key){
        return binarySearchUtil(array, 0, array.length-1, key);
    }
    public static int binarySearchUtil(int []array, int start, int end, int key){
        if(start<=end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[start] <array[mid]) {
                if (key >= array[start] && key <=array[mid]) {
                    return binarySearchUtil(array, start, mid - 1, key);
                }
                return binarySearchUtil(array, mid + 1, end, key);
            }
            if (key >=array[mid] && key <= array[end]) {
                return binarySearchUtil(array, mid + 1, end, key);
            }
            return binarySearchUtil(array, start, mid-1, key);
        }
        return -1;
    }
}
