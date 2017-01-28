package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 25/01/17.
 */
public class RatInMaze {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [][] maze = new int[m][n];
        for(int i=0; i<m; i++){
            String [] row = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                maze[i][j] = Integer.parseInt(row[j]);
            }
        }
        int [][] solution = new int[m][n];
        if(solveMazeUtil(maze, 0,0, solution)==false){
            System.out.println("Solution Doesn't exist");
        }else {
            printSolution(solution);
        }
    }
    public static boolean solveMazeUtil(int [][] maze, int x, int y, int [] [] solution){
        int m = maze.length;
        int n = maze[0].length;
        if(x==m-1 && y==n-1){
            solution[x][y] =1;
            return true;
        }
        if(isSafe(maze, x, y)){
            solution[x][y] =1;
            if(solveMazeUtil(maze, x, y+1, solution)){
                return true;
            }
            if(solveMazeUtil(maze, x+1, y, solution)){
                return true;
            }
            solution[x][y] =0;
            return false;
        }
        return false;
    }
    public static boolean isSafe(int [][] maze, int x, int y){
        int m = maze.length;
        int n = maze[0].length;
        if(x>=0 && x<m && y>=0 && y<n && maze[x][y]==1){
            return true;
        }else {
            return false;
        }
    }
    public static void printSolution(int [][]sol){
        int m = sol.length;
        int n = sol[0].length;
        for(int i=0; i<m ;i++){
            for(int j=0; j<n;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
}
