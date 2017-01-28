package util.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 19/12/16.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        int [] sortedArray = CountSort.countSort(data);
        for(int value: sortedArray){
            System.out.print(value +" ");
        }
    }
}
