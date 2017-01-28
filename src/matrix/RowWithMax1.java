package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/01/17.
 */
public class RowWithMax1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] rowCol = br.readLine().split(" ");
        int m = Integer.parseInt(rowCol[0]);
        int n = Integer.parseInt(rowCol[1]);
        String [] str = br.readLine().split(" ");
        int [][] matrix= new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(str[j+i*n]);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(getRowNumber(matrix));
    }
    public static int getRowNumber(int [][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int index = binarySearch(matrix[0], 0, n-1);
        if(index==-1){
            index = n-1;
        }
        int minRow =0;
        for(int i=1; i<m; i++){
            while (index>0 && matrix[i][index]==1){
                index--;
                minRow = i;
            }
        }
        return minRow;
    }
    public static int binarySearch(int [] array, int start, int end){
        if(start<=end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || array[mid - 1] == 0) && array[mid] == 1) {
                return mid;
            }
            if (array[mid] == 0) {
                return binarySearch(array, mid + 1, end);
            } else {
                return binarySearch(array, start, mid - 1);
            }
        }else{
            return -1;
        }
    }
}
