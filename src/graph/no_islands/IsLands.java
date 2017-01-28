package graph.no_islands;

/**
 * Created by neelabhsingh on 15/01/17.
 */
public class IsLands {
    int countIslands(int [][] island){
        int row = island.length;
        int col = island[0].length;
        int noOfLands = 0;
        boolean [][] visited = new boolean[row][col];
        for(int m=0; m<row; m++){
            for(int n=0; n<col; n++){
                if(island[m][n] == 1 && !visited[m][n]){
                    dfs(island, m, n, visited, row, col);
                    noOfLands++;
                }
            }
        }
        return noOfLands;
    }
    private void dfs(int [][]island, int i, int j,  boolean [][] visited, int row, int col){
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for(int k=0; k<8; k++){
            int x = rowNbr[k]+i;
            int y = colNbr[k]+j;
            if(isSafe(x, y, row, col) && island[x][y]==1 && visited[x][y]==false ){
                dfs(island, x, y, visited, row, col);
            }
        }
    }
    private boolean isSafe(int i, int j, int row, int col){
        if((i>=0 && i<row) && (j>=0 && j<col)){
            return true;
        }else {
            return false;
        }
    }
}
