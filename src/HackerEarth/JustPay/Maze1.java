package HackerEarth.JustPay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by neelabhsingh on 12/01/17.
 */
public class Maze1 {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String []  line = br.readLine().split(" ");
        int [] value = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(line[i]);
        }
        System.out.println(repeatedElement(value));
    }
    public static int repeatedElement(int [] array){
        Map<Integer, Integer> hashMap = new HashMap<>();
        int size = array.length;
        for(int i=0; i<size; i++){
            if(hashMap.containsKey(array[i])){
                hashMap.put(array[i], hashMap.get(array[i])+1);
            }else {
                hashMap.put(array[i], 1);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        Iterator itr = hashMap.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            if(maxValue< (int)pair.getValue()){
                maxValue = (int)pair.getValue();
            }
        }
        return maxValue;
    }
}
