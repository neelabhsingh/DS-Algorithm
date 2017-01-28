package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/01/17.
 */
/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
 * then make all the cells of ith row and jth column as 1.
 */
public class BooleanMatrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            String [] rowCol = br.readLine().split(" ");
            int m = Integer.parseInt(rowCol[0]);
            int n = Integer.parseInt(rowCol[1]);
            String [] strArray = br.readLine().split(" ");
            int [][] numbers = new int[m][n];
            for(int i=0; i<m;i++){
                for(int j=0; j<n; j++) {
                    numbers[i][j] = Integer.parseInt(strArray[j+i*n]);
                }
            }
            convertIntoBooleanMatrix(numbers);
            for(int i=0; i<m;i++){
                for(int j=0; j<n; j++) {
                    System.out.print(numbers[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static void convertIntoBooleanMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean colFlag =false;
        boolean rowFlag =false;
        for(int i=0; i<m ;i++){
            if(matrix[i][0]==1){
                rowFlag=true;
                break;
            }
        }

        for(int j=0; j<n;j++){
            if(matrix[0][j]==1){
                colFlag =true;
                break;
            }
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][0]=1;
                    matrix[0][j]=1;
                }
            }
        }
        for(int i=1; i<m;i++){
            for(int j=1; j<n;j++){
                if(matrix[i][0]==1|| matrix[0][j]==1){
                    matrix[i][j]=1;
                }
            }
        }
        if(rowFlag){
            for(int i=0; i<m; i++){
                matrix[i][0]=1;
            }
        }
        if(colFlag){
            for(int j=0; j<m; j++){
                matrix[0][j]=1;
            }
        }
    }
}
