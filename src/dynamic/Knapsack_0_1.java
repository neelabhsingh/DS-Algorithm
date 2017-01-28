package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 26/12/16.
 */
public class Knapsack_0_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int N = Integer.parseInt(br.readLine());
            int W = Integer.parseInt(br.readLine());
            String [] valueString = br.readLine().split(" ");
            int [] values = new int[N];
            for(int i=0; i<N; i++){
                values[i]= Integer.parseInt(valueString[i]);
            }
            String [] weightString = br.readLine().split(" ");
            int [] weights = new int[N];
            for(int i=0; i<N; i++){
                weights[i]= Integer.parseInt(weightString[i]);
            }
            System.out.println(knapsack(weights, values, N, W));
        }
    }
    public static int knapsack(int [] wt, int [] value, int n, int W){
        int [][] table = new int[n+1][W+1];
        for(int i=0; i<=n;i++){
            for (int w=0; w<=W; w++){
                if(w==0 || i==0){
                    table[i][w]=0;
                }else if(wt[i] <=w){
                    table[i][w] = Math.max(value[i-1]+table[i-1][w-wt[i-1]], table[i-1][w]);
                }else{
                    table[i][w] = table[i-1][w];
                }
            }
        }
        return table[n][W];
    }
}
