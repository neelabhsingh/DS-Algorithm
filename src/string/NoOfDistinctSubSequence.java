package string;

/**
 * Created by neelabhsingh on 23/09/16.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
public class NoOfDistinctSubSequence {
    public static void main(String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for(int i=0;i<testCases;i++) {
            String word = br.readLine();
            int result = getLength(word);
            System.out.print(result%10000007);
        }
    }
    public static int getLength(String word){
        HashSet<String> hashSet = new HashSet<String>();
        int size = word.length();
        for(int i=0;i<size;i++){
            for(int j=i;j< size;j++){
                String str = word.substring(i, j+1);
                hashSet.add(str);
            }
        }
        //System.out.println(al);
        return hashSet.size()+1;
    }
}
