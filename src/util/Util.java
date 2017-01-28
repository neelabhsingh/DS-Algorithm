package util;

/**
 * Created by neelabhsingh on 18/12/16.
 */
public class Util {
    public static void swapArrayElements(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static void printArraysElements(int [] array, int size){
        for(int i=0; i<size; i++){
            System.out.print(array[i]+ " ");
        }
    }
}
