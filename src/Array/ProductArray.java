package Array;

/**
 * Created by neelabhsingh on 14/01/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*** You are given an array of integers(with all valid input) You have to write a function which will
* produce another array, where the value in each index of the array will be the product of all values in
* the given array accept that index.
* */
public class ProductArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []inString = br.readLine().split(" ");
        int len = inString.length;
        int [] intArray = new int[len];
        int i=0;
        for(String str: inString){
            intArray[i] = Integer.parseInt(str);
            i++;
        }
        int [] newProductArray = generateNewArray(intArray);
        for(int value: newProductArray){
            System.out.print(value+" ");
        }
    }
    public static int [] generateNewArray(int [] array){
        int oneZero = 1;
        int allProduct = 1;
        int zeroCount = 0;
        int len = array.length;
        for(int i=0; i<len; i++){
            if(array[i]==0){
                if(zeroCount==0){
                    zeroCount = 1;
                }else{
                    allProduct = 0;
                    zeroCount = 2;
                }
            }else {
                allProduct*=array[i];
            }
        }

        int [] newArray = new int[len];
        if(zeroCount == 2){
            Arrays.fill(newArray, 0);
        }else {
            for(int i=0; i<len; i++){
                if(zeroCount ==1){
                    if(array[i]==0){
                        newArray[i] = allProduct;
                    }else {
                        newArray[i] = 0;
                    }
                }else{
                    newArray[i] = (int)allProduct/array[i];
                }
            }
        }
        return newArray;
    }
}
