package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by neelabhsingh on 20/01/17.
 */
public class MinMaxNumberFormation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int size =str.length;
        int [] array = new int[size];
        for(int i=0; i<size; i++){
            array[i]= Integer.parseInt(str[i]);
        }
        String [] minArray = Arrays.copyOf(str, array.length);
        String [] maxArray = Arrays.copyOf(str, array.length);

        System.out.println("Get Min Number: "+ getSmallerstNumber(minArray));
        System.out.println("Get Max Number: "+ getLargestNumber(maxArray));
    }


    public static String getSmallerstNumber(String [] array){
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                String minNum1 = num1+num2;
                String minNum2 = num2+num1;
                return minNum1.compareTo(minNum2);
            }
        });
        String result ="";
        for(String num : array){
            result+=num;
        }
        return result;
    }
    public static String getLargestNumber(String [] array){
        Arrays.sort(array, new Comparator<String>(){
            @Override
            public int compare(String num1, String num2) {
                String max1 = num1+num2;
                String max2 = num2+num1;
                return max2.compareTo(max1);
            }
        });
        String result ="";
        for(String num : array){
            result+=num;
        }
        return result;
    }
}
