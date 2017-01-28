package matrix;

/**
 * Created by neelabhsingh on 15/01/17.
 */

/**
 * Given a matrix of 0's and 1's find the number of groups of 1's in the matrix.
 * A group of 1's can be formed if a 1 is present either vertically or horizontally to the
 * adjacent 1 and not diagonally.
 * https://www.careercup.com/question?id=14948781
 */
public class NumberOfGroupOf_1 {
    public static int row =0;
    public static int col =0;
    public static void main(String[] args) {
        int matrix[][]=  new int[][]{
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        row = matrix.length;
        col = matrix[0].length;
        boolean [][] visited = new boolean[row][col];
        System.out.println(groupOfOne(matrix, visited));
    }
    private static int groupOfOne(int [][] matrix, boolean [][] visited){
        int groupOfOne =0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    dfs(matrix, i, j, visited);
                    groupOfOne++;
                }
            }
        }
        return groupOfOne;
    }
    private static void dfs(int [][]matrix, int i, int j,  boolean [][] visited){
        int rowNbr[] = new int[] {-1,  0,  0,  1};
        int colNbr[] = new int[] { 0, -1,  1,  0};
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int x = rowNbr[k]+i;
            int y = colNbr[k]+j;
            if(isSafe(matrix, visited, x, y)){
                dfs(matrix, x, y, visited);
            }
        }
    }
    private static boolean isSafe(int [][] matrix, boolean [][] visited, int i, int j){
        if((i>=0 && i<col) && (j>=0 && j<row) && !visited[i][j] && matrix[i][j]==1){
            return true;
        }else {
            return false;
        }
    }
}
