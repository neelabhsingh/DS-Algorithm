package interviews.HelloGroup;

import java.util.*;

/**
 * Created by neelabhsingh on 05/01/17.
 */
public class CityByDistance {
    public static void main(String[] args) {
        int vertex = 10;
        Graph graph = new Graph(vertex);
        graph.addEdge(0, 4);
        graph.addEdge(0, 5);
        graph.addEdge(0, 9);
        graph.addEdge(1, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 8);
        graph.addEdge(3, 9);
        graph.addEdge(4, 2);
        graph.addEdge(4, 0);
        graph.addEdge(5, 0);
        graph.addEdge(5, 6);
        graph.addEdge(6, 5);
        graph.addEdge(7, 1);
        graph.addEdge(7, 9);
        graph.addEdge(8, 2);
        graph.addEdge(9, 0);
        graph.addEdge(9, 3);
        graph.addEdge(9, 7);
        graph.bfs(vertex, 1);
    }
}

class Graph{
    private int vertex;
    private LinkedList<Integer>[] adj;
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
            System.out.print(i +"");
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
        Queue<Integer> nextQueue = new LinkedList<Integer>();
        queue.add(source);
        visisted[source] = true;
        List<Integer> cityDistance = new ArrayList<Integer>();
        cityDistance.add(queue.size());
        while (!queue.isEmpty()){
            int i = queue.poll();
            System.out.print(i +"-->");
            Iterator itr = adj[i].iterator();
            while (itr.hasNext()){
                int j = (Integer)itr.next();
                if(visisted[j]==false){
                    nextQueue.add(j);
                    visisted[j] = true;
                }
            }
            if(queue.isEmpty()){
                queue = nextQueue;
                nextQueue = new LinkedList<Integer>();
                cityDistance.add(queue.size());
                nextQueue.clear();
            }
        }
        System.out.println();
        Iterator itr = cityDistance.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
}