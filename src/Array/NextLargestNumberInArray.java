package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neelabhsingh on 25/01/17.
 */

/**
 * Given an array A [ ] having distinct elements, the task is to find the next greater element for each element of
 * the array in order of their appearance in the array. If no such element exists, output -1
 */
public class NextLargestNumberInArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        int size = str.length;
        int [] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = Integer.parseInt(str[i]);
        }
        int [] result = getNextLargestNumber(numbers);
        for(int i=0; i<size; i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int [] getNextLargestNumber(int [] array){
        int size =array.length;
        int [] result = new int[size];
        if(size==0){
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<size; i++){
            int next = array[i];
            if(!stack.isEmpty()){
                int index = stack.pop();
                while (next> array[index]){
                    result[index] = next;
                    if(stack.isEmpty()){
                        break;
                    }
                    index = stack.pop();
                }
                if(array[index]>next){
                    stack.push(index);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[ stack.pop()] = -1;
        }
        return result;
    }
}
