package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 12/01/17.
 */
public class BuyAndSellStockByK {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strings = br.readLine().split(" ");
        int size = strings.length;
        int [] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(strings[i]);
        }
    }
    public static int BuySellStockByK(int [] price, int k){
        int size = price.length;
        int [][] profit = new int[size+1][k+1];
        for(int i=0; i<=k;i++){
            profit[0][i] = 0;
        }
        for(int i=0;i<=size;i++){
            profit[i][0] =0;
        }

        for(int i=1; i<=k;i++){
            for(int j=1; j<size; j++){
                int maxSoFar = Integer.MIN_VALUE;
                for(int m=0; m<j;m++){
                    maxSoFar = Math.max(maxSoFar, price[i]- price[m] + profit[i-1][m]);
                }
                profit[i][j] = Math.max(profit[i][j-1], maxSoFar);
            }
        }
        return profit[size-1][k];
    }
}
