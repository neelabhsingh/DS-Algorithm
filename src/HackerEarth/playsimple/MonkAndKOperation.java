package HackerEarth.playsimple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 15/01/17.
 */
public class MonkAndKOperation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase  = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String [] array1 = br.readLine().split(" ");
            int N = Integer.parseInt(array1[0]);
            int K = Integer.parseInt(array1[1]);
            String [] array2 = br.readLine().split(" ");
            int size = array2.length;
            int [] nums = new int[size];
            for(int j=0; j<size; j++ ){
                nums[j] = Integer.parseInt(array2[j]);
            }
            System.out.println(maxProduct(nums, N, K));
        }
    }
    public static int maxProduct(int [] array, int N, int K){
        return Math.max(maxProductUtil(array, 0, N-2, K), maxProductUtil(array,1, N-1, K));
    }
    public static int maxProductUtil(int [] array, int start, int end, int k){
        if(k==0 || start>end){
            return 1;
        }
        int currentMAX = array[start]*array[end];
        int max1 = maxProductUtil(array, start+1, end, k-1);
        int max2 = maxProductUtil(array, start, end-1, k-1);
        int childMax = Math.max(max1, max2);
        return Math.max(currentMAX, childMax);
    }
    public static int maxProduct_v2(int [] array, int start, int end, int k){
        int size = array.length;
        int [][] prodArray = new int[size][size];
        return -1;
    }
}
