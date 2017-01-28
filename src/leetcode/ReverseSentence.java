package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 22/12/16.
 */
public class ReverseSentence {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reverseString(br.readLine()));
    }
    public static String reverseString(String str){
        int size = str.length();
        StringBuilder sb = new StringBuilder();
        int start;
        int end;
        for(int i=size-1; i>=0; i--){
            while (i>=0 && str.charAt(i) == ' '){
                i--;
            }
            end = i;
            if(i<0){
                break;
            }
            if(sb.length()!=0){
                sb.append(' ');
            }
            while (i>=0 && str.charAt(i)!= ' '){
                i--;
            }
            start = i+1;
            sb.append(str.substring(start, end+1));
        }
        return sb.toString();
    }
}
