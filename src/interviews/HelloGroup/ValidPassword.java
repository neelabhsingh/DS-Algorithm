package interviews.HelloGroup;

/**
 * Created by neelabhsingh on 05/01/17.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ValidPassword {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result=getValidPassword(str);
        System.out.println(result);
    }
    public static int getValidPassword(String str){
        int count = 0;
        String newStr = str.replaceAll("\\d", "_");
        String [] array = newStr.split("_+");
        for(String value: array){
            count+=countAllValidPassword(value);
            //System.out.println(value);
        }
        return count==0?-1:count;
    }
    public static int countAllValidPassword(String str){
        int count =0;
        Set<String> set = new HashSet<String>();
        int size = str.length();
        for( int i = 0;  i< size ; i++ ) {
            for( int j = 1; j <= size - i; j++ ) {
                String subStr = str.substring(i, i+j);
                if(!subStr.equals(subStr.toLowerCase())){
                    set.add(subStr);
                }
            }
        }

        return set.size();
    }
}
