package Array;

import util.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 19/12/16.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        removeDuplicates(data);
    }
    public static void  removeDuplicates(int [] data){
        int size1 = data.length;
        int i = 0;
        int j = 0;
        while (j<size1){
            if(data[i] !=data[j]){
                i++;
                data[i]=data[j];
            }
            j++;
        }
        Util.printArraysElements(data, i+1);
    }
}
