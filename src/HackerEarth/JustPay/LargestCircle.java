package HackerEarth.JustPay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by neelabhsingh on 13/01/17.
 */
public class LargestCircle {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String []  line = br.readLine().split(" ");
        int [] value = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(line[i]);
        }
        System.out.println(largestCircle(value));
    }
    public static int largestCircle(int []array){
        int size = array.length;
        boolean [] visited = new boolean[size];
        Arrays.fill(visited, false);
        int maxCircle = -1;
        for(int i=0; i<size; i++){
            if(!visited[i]){
                visited[i] =true;
                int count =1;
                int newIndex = array[i];
                boolean insideLoop = false;
                while ((i!=newIndex && newIndex!=-1) && !visited[newIndex]){
                    count++;
                    visited[newIndex] = true;
                    insideLoop = true;
                    newIndex = array[newIndex];
                }
                if(newIndex==i && insideLoop){
                    maxCircle= Math.max(maxCircle, count);
                }
            }
        }
        return maxCircle;
    }
}
