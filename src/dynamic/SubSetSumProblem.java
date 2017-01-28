package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by neelabhsingh on 15/01/17.
 */
public class SubSetSumProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []string = br.readLine().split(" ");
        int size = string.length;
        int [] array = new int[size];
        for (int i=0; i<size; i++){
            array[i] = Integer.parseInt(string[i]);
        }
        int sum = Integer.parseInt(br.readLine());
        System.out.println(subSetSum(array, sum));
    }
    public static boolean subSetSum(int []array, int sum){
        int m = array.length;
        boolean [][] dynamicTable = new boolean[m+1][sum];

        for(int i=0; i<=m; i++){
            dynamicTable[i][0] = true;
        }
        for(int j=1; j<=sum ;j++){
            dynamicTable[0][j] = false;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=sum; j++){
                dynamicTable[i][j] = dynamicTable[i-1][j];
                if(dynamicTable[i][j]==false && j>=array[i-1]){
                    dynamicTable[i][j] = dynamicTable[i-1][j-array[i-1]];
                }
            }
        }
        return dynamicTable[m][sum];
    }
}
