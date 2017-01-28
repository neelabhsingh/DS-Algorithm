package leetcode.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class ValidPalindrome {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String palindrome = br.readLine();
        System.out.println(isPalidnrome(palindrome));
    }
    public static boolean isPalidnrome(String string){
        if(string.isEmpty()){
            return true;
        }
        int start =0;
        int end = string.length()-1;
        while (start<=end){
            char startChar = string.charAt(start);
            char endChar = string.charAt(end);
            if(!Character.isLetterOrDigit(startChar)){
                start++;
            }else if(!Character.isLetterOrDigit(endChar)){
                end--;
            }else {
                if(Character.toLowerCase(startChar)!=Character.toLowerCase(endChar)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
