package geeksforgeeks.number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 12/01/17.
 */
public class TrailingZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.parseInt(br.readLine());
        System.out.println(countTrailingZero(value));
    }
    public static int countTrailingZero(int n){
        int count =0;
        for (int i=5; n/i>=1; i*=5){
            count+=n/i;
        }
        return count;
    }
}
