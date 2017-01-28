package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 15/01/17.
 */
public class MaximumSizeSqureMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] size = br.readLine().split(" ");
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);
        int [][] matrix = new int[m][n];
        for(int i=0; i<m;i++){
            String [] row = br.readLine().split(" ");
            for (int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }
        System.out.println(getMaxOneSizeMatrixLength(matrix));
    }
    public static int getMaxOneSizeMatrixLength(int [] []matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int overAllMax = 0;
        int [][] copyMatrix = new int[m][n];
        for(int i=0; i<m ;i++){
            for(int j=0; j<n;j++){
                if(i==0 || j==0){
                    copyMatrix[i][j] = matrix[i][j];
                    overAllMax = Math.max(overAllMax, copyMatrix[i][j]);
                }else if(matrix[i][j]==1){
                    int max = Math.min(copyMatrix[i-1][j-1], Math.min(copyMatrix[i][j-1], copyMatrix[i-1][j]))+1;
                    copyMatrix[i][j] =max;
                    overAllMax = Math.max(overAllMax, max);
                }else{
                    copyMatrix[i][j] = 0;// When matrix[i][j] ==0
                }
            }
        }
        return overAllMax;
    }
}
