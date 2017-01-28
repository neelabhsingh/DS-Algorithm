package leetcode.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 11/01/17.
 */
public class BuyAndSellStockByOne {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] strings = br.readLine().split(" ");
        int size = strings.length;
        int [] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = Integer.parseInt(strings[i]);
        }
    }
    public static int maximumPrice(int [] prices){
        int minValue = Integer.MAX_VALUE;
        int profit = 0;
        int size = prices.length;
        for(int i=0; i<size; i++){
            minValue = Math.min(minValue, prices[i]);
            profit = Math.max(profit, prices[i]-minValue);
        }
        return profit;
    }
}
