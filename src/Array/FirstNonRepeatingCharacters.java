package Array;

/**
 * Created by neelabhsingh on 25/12/16.
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstNonRepeatingCharacters {
    public static void main(String[] args) {
        Deque<Character> deque = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        boolean [] visited = new boolean[256];
        Arrays.fill(visited, false);
        int len = str.length();
        for(int i=0; i<len;i++){
            char index = str.charAt(i);
            if(visited[index] == true){
                deque.remove(index);
            }else{
                deque.addLast(index);
                visited[index] = false;
            }
        }
    }
}

