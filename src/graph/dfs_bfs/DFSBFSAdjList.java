package graph.dfs_bfs;
import java.util.*;
/**
 * Created by neelabhsingh on 05/11/16.
 */
public class DFSBFSAdjList {
    public static void main(String [] args){
        int vertex = 6;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 1);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        System.out.println("DFS");
        graph.dfs(vertex, 0);
        System.out.println("\nBFS");
        graph.bfs(vertex, 0);
    }
}
class Graph{
    private int vertex;
    private LinkedList<Integer> [] adj;
    Graph(int vertex){
        this.vertex = vertex;
        adj =new LinkedList[vertex];
        for(int i =0; i< vertex; i ++){
            adj[i] = new LinkedList<>();
        }
    }
    public LinkedList[] getListMatrix(){
        return this.adj;
    }
    public void addEdge(int u, int v){
        adj[u].add(v);
    }
    public void dfs(int graphSize, int source){
        boolean [] visited = new boolean[graphSize];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        visited[source] = true;
        while (!stack.isEmpty()){
            int i = stack.pop();
            System.out.print(i +"-->");
            Iterator itr = adj[i].iterator();
            while (itr.hasNext()){
                int j = (Integer) itr.next();
                if(visited[j] == false){
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }

    public void bfs(int graphSize, int source){
        boolean [] visisted = new boolean[graphSize];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visisted[source] = true;
        while (!queue.isEmpty()){
            int i = queue.poll();
            System.out.print(i+"-->");
            Iterator itr = adj[i].iterator();
            while (itr.hasNext()){
                int j = (Integer)itr.next();
                if(visisted[j]==false){
                    queue.add(j);
                    visisted[j] = true;
                }
            }
        }
    }
}