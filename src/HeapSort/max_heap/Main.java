package HeapSort.max_heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 18/12/16.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        MaxHeap.sort(data);
        for (int value: data){
            System.out.print(value+" ");
        }
    }
}
