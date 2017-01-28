package interviews;

import java.util.Scanner;

/**
 * Created by neelabhsingh on 21/12/16.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            String str = scan.next();
            System.out.println(getBalance(str));
        }
    }
    public static String getBalance(String str){
        StringBuilder sb = new StringBuilder(str);
        int size = str.length();
        int right =0;
        for(int i=0; i<size; i++) {
            if (str.charAt(i) == ')') {
                if(right==0){
                    sb.insert(0, '(');
                }else {
                    right--;
                }
            } else {
                right++;
            }
        }
        while (right>0){
            sb.append(')');
            right--;
        }
        return sb.toString();
    }
}
