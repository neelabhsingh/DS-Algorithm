package graph.dfs_bfs;

import java.util.*;

/**
 * Created by neelabhsingh on 05/11/16.
 */
public class DFSBFSDemoAdjMatrix {
    public static void main(String [] args){
        int [][] graph = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0}
        };
        System.out.println("BFS Traversal");
        bfsTraversal(graph, 0);
        System.out.println();
        System.out.println("DFS Traversal");
        dfsTraversal(graph, 0);
    }
    //BFS Traversal
    public static void bfsTraversal(int [][] graph, int source){
        int graphSize = graph[0].length;
        boolean [] visited = new boolean[graphSize];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        System.out.print(source+"-->'");
        visited[source] = true;
        while (!queue.isEmpty()){
            int i = queue.poll();
            for(int j=0; j<graphSize; j++){
                if(graph[i][j] ==1 && visited[j] == false){
                    System.out.print(j+"-->'");
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
    //DFS Traversal
    public static void dfsTraversal(int [][] graph, int source){
        int graphSize = graph[0].length;
        boolean visited[] = new boolean[graphSize];
        Stack<Integer> stack = new Stack<Integer>();
        visited[source] = true;
        stack.push(source);
        while (!stack.isEmpty()){
            int i = stack.pop();
            System.out.print(i+"-->'");
            for(int j=0; j<graphSize; j++){
                if(graph[i][j] == 1 && visited[j] == false){
                    visited[j] = true;
                    stack.push(j);
                }
            }
        }
    }
}
