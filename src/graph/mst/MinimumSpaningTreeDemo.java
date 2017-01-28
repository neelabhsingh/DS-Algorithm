package graph.mst;
import java.util.*;
/**
 * Created by neelabhsingh on 06/11/16.
 */
public class MinimumSpaningTreeDemo {
    public static void main(String [] args){
        int graph[][] = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };
        MST mst = new MST(5);
        int sourceVertex = 0;
        mst.primMST(graph, sourceVertex);
    }
}
class MST{
    private int vertex;
    public MST(int vertex){
        this.vertex = vertex;
    }
    public int getMinVertex(int [] keys, boolean [] mstSet){
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        int vertex = keys.length;
        for(int i=0; i<vertex; i++){
            if(mstSet[i]==false && minValue > keys[i]){
                minValue = keys[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public void primMST(int [][] graph, int source){
        if(graph == null || graph.length ==0){
            return;
        }
        int vertex = graph[0].length;
        int [] keys = new int[vertex];
        boolean [] mstSet = new boolean[vertex];
        int [] parent = new int[vertex];
        Arrays.fill(keys, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
        keys[source] =0;
        parent[source] = -1;
        for(int i=0; i< vertex-1; i++){
            int u = getMinVertex(keys, mstSet);
            mstSet[u] = true;
            for(int v=0; v < vertex; v++){
                if(graph[u][v] !=0 && mstSet[v]==false && graph[u][v]< keys[v]){
                    parent[v] = u;
                    keys[v] = graph[u][v];
                }
            }
        }
        printMST(parent, vertex, source, graph);
    }
    public void printMST(int parent[], int v, int source, int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < v; i++){
            if(i!=source){
                System.out.println(parent[i]+" - "+ i+"    "+graph[i][parent[i]]);
            }
        }
    }
}
