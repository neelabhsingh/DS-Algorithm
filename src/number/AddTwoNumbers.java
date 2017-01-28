package number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 20/01/17.
 */
/**
 * Write a function that adds two numbers. You should not use + or any other arithmetic operators.
* */
public class AddTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] numbers = br.readLine().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        System.out.println(addWithoutUsingOperator(a, b));
    }
    public static int addWithoutUsingOperator(int a, int b){
        if(b==0){
            return a;
        }
        int sum = a^b;
        int carry = (a&b)<<1;
        return addWithoutUsingOperator(sum, carry);
    }
}
