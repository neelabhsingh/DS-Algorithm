package hackerrank.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 13/01/17.
 */
public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        System.out.println(getPalindromeIndex(string));
    }
    private static int getPalindromeIndex(String string){
        int start = 0;
        int end = string.length()-1;
        while (start < end){
            if(string.charAt(start)!=string.charAt(end)){
                if(isPalindrome(string.substring(start, end))){
                    return end;
                }else if(isPalindrome(string.substring(start+1, end+1))){
                    return start;
                }else {
                    return -1;
                }
            }
            start++;
            end--;
        }
        return -1;
    }
    private static boolean isPalindrome(String string){
        int start =0;
        int end = string.length()-1;
        while (start<end){
            if(string.charAt(start)!=string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
