package leetcode.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 24/01/17.
 */
public class NumberOfIsLands {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [][] isLands = new int[m][n];
        for(int i=0; i<m; i++){
            String [] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                isLands[i][j] = Integer.parseInt(row[j]);
            }
        }
        System.out.println(getNumberOfIsLands(isLands));
    }
    public static int getNumberOfIsLands(int [][]matrix){
        int m = matrix.length;
        if(m==0){
            return 0;
        }
        int n = matrix[0].length;
        int totalIsLands =0;
        boolean [][] visited = new boolean[m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(matrix[i][j]==1 && !visited[i][j]) {
                    dfs(matrix, visited, i, j);
                    totalIsLands++;
                }
            }
        }
        return totalIsLands;
    }
    public static void dfs(int [][] matrix, boolean [][] visited, int i, int j){
        int rowNbr[] = new int[] {-1,  0,  0,  1};
        int colNbr[] = new int[] { 0, -1,  1,  0};
        visited[i][j] = true;
        for(int k=0; k<4;k++){
            int x = rowNbr[k]+i;
            int y = colNbr[k]+j;
            if(isSafe(matrix, visited, x, y)){
                dfs(matrix, visited, x, y);
            }
        }
    }

    public static boolean isSafe(int [][]matrix, boolean [][] visited, int i, int j){
        int m = matrix.length;
        int n = matrix[0].length;
        if((i>=0 && i<m )&& (j>=0 && j<n) && matrix[i][j]==1 && !visited[i][j]){
            return true;
        }else {
            return false;
        }
    }
}
