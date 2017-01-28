package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/01/17.
 */
public class LargestSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] rowCol = br.readLine().split(" ");
        int m = Integer.parseInt(rowCol[0]);
        int n = Integer.parseInt(rowCol[1]);
        int [][] matrix= new int[m][n];
        for(int i=0; i<m; i++){
            String [] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.println(getLargestSqrtMatrix(matrix));
    }
    public static int getLargestSqrtMatrix(int [][]matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] sqrtMatrix = new int[m][n];
        int maxLength = 0;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(i==0 || j==0){
                    sqrtMatrix[i][j] = matrix[i][j];
                    maxLength = Math.max(maxLength, sqrtMatrix[i][j]);
                }else{
                    if(matrix[i][j]==1){
                        sqrtMatrix[i][j]=1+getMinimumFromThree(sqrtMatrix[i-1][j-1], sqrtMatrix[i][j-1], sqrtMatrix[i-1][j]);
                        maxLength = Math.max(maxLength, sqrtMatrix[i][j]);
                    }
                }
            }
        }
        return maxLength;
    }
    public static int getMinimumFromThree(int a, int b, int c){
        return a<b?(a<c?a:c):(b<c?b:c);
    }
}

