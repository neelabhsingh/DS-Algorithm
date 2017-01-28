package leetcode.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neelabhsingh on 23/01/17.
 */
public class LongestValidParenthesis {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parenthesis = br.readLine();
        System.out.println(validParenthesis(parenthesis));
    }
    public static int validParenthesis(String str){
        Stack<Integer> validParenthesis = new Stack<>();
        int lastMatchIndex =-1;
        int maxLength =0;
        int size = str.length();
        int i=0;
        while (i<size){
            char temp = str.charAt(i);
            switch (temp){
                case '(':
                    validParenthesis.push(i);
                    break;
                case ')':
                    if(validParenthesis.isEmpty()){
                        lastMatchIndex =i;
                    }else {
                        validParenthesis.pop();
                        if(validParenthesis.isEmpty()){
                            maxLength = Math.max(maxLength, i-lastMatchIndex);
                        }else {
                            maxLength= Math.max(maxLength, i- validParenthesis.peek());
                        }
                    }
                    break;
            }
            i++;
        }
        return maxLength;
    }
}
