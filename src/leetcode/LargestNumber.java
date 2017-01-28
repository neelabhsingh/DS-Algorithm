package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by neelabhsingh on 21/12/16.
 */
public class LargestNumber {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
    }
    public static  String largestNumber(int[] num){
        int size = num.length;
        String [] stringArray = new String[size];
        for(int i=0; i<size; ++i){
            stringArray[i] = String.valueOf(num[i]);
        }
        Arrays.sort(stringArray, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return (str2+str1).compareTo(str1+str2);
            }
        });
        StringBuilder br = new StringBuilder();
        for(String str: stringArray){
            br.append(str);
        }
        while (br.charAt(0) =='0' && br.length()>1){
            br.deleteCharAt(0);
        }
        return br.toString();
    }
}
