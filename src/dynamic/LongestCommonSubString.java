package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 19/01/17.
 */
public class LongestCommonSubString {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(LongestCommonSubString(str1, str2));
    }
    public static int LongestCommonSubString(String str1, String str2){
        int m = str1.length();
        int n= str2.length();
        int [][] dTable = new int[m+1][n+1];
        int maxLength =0;
        for(int i=0; i<=m;i++){
            for(int j=0; j<=n;j++){
                if(i==0 || j==0){
                    dTable[i][j]=0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dTable[i][j] = dTable[i-1][j-1]+1;
                    maxLength = Math.max(maxLength, dTable[i][j]);
                }else {
                    dTable[i][j]= 0;
                }
            }
        }
        return maxLength;
    }
}
