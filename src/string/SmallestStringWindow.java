package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 20/01/17.
 */
public class SmallestStringWindow {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(getSmallestWindow(str1, str2));
    }
    public static String getSmallestWindow(String s, String t){
        int len1 = s.length();
        int len2 = t.length();
        int minWindowLength = Integer.MAX_VALUE;
        int startWindow = -1;
        int endWindow = -1;
        int currentWindow = 0;
        int [] needToFind = new int[256];
        Arrays.fill(needToFind, 0);
        int [] hasToFind = new int[256];
        Arrays.fill(hasToFind, 0);
        for(int i=0; i<len2; i++){
            needToFind[(int)t.charAt(i)]++;
        }
        int count =0;
        for(int start=0, end=0; end<len1; end++){
            if(needToFind[(int)s.charAt(end)]==0){
                continue;
            }
            hasToFind[(int)s.charAt(end)]++;
            if(hasToFind[(int)s.charAt(end)]<=needToFind[(int)s.charAt(end)]){
                count++;
            }
            if(count==len2){
                while (needToFind[(int)s.charAt(start)]==0 || hasToFind[(int)s.charAt(start)] > needToFind[(int)s.charAt(start)]){
                    if(hasToFind[(int)s.charAt(start)] > needToFind[(int)s.charAt(start)]){
                        hasToFind[(int)s.charAt(start)]--;
                    }
                    start++;
                }
                currentWindow = end - start+1;
                if(currentWindow < minWindowLength){
                    minWindowLength = currentWindow;
                    startWindow = start;
                    endWindow = end;
                }
            }
        }
        return count==len2? s.substring(startWindow, endWindow+1): "";
    }
}
