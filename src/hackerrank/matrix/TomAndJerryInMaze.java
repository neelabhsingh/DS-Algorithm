package hackerrank.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 24/01/17.
 */
public class TomAndJerryInMaze {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [][] maze = new int[m][n];
        for(int i=0; i<m; i++){
            String [] row = br.readLine().split(" ");
            for(int j=0; j<n;j++){
                maze[i][j] = Integer.parseInt(row[j]);
            }
        }
        String [] coordinates = br.readLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);
        System.out.println(minMoves(maze, x,y));
    }
    public static int minMoves(int [][] maze, int x, int y){
        return -1;
    }
}
