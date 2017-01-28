package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by neelabhsingh on 20/12/16.
 */
public class SlidingWindow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        int k = Integer.parseInt(br.readLine());
        int [] result = getMaximumSlidingWindow(data, k);
        for(int value: result){
            System.out.print(value +" ");
        }
    }
    public static int [] getMaximumSlidingWindow(int [] num, int k){
        int [] result = {};
        int [] indexResult = {};
        if(k==0){
            return result;
        }
        int size = num.length;
        indexResult = new int[size-k+1];
        result = new int[size-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int i=0;
        for(; i<k; i++){
            while (queue.size() >0 && num[queue.peekLast()] <= num[i]){
                queue.removeLast();
            }
            queue.add(i);
        }
        int j=0;
        for(i=k; i<size; i++){
            indexResult[j++] = queue.peekFirst();
            if(queue.size()>0 && (i-queue.peekFirst())>k-1){
                queue.removeFirst();
            }
            while (queue.size() >0 && num[queue.peekLast()] <= num[i]){
                queue.removeLast();
            }
            queue.add(i);
        }
        indexResult[j++] = queue.peekFirst();
        int m=0;
        for(int index: indexResult){
            result[m++] = num[index];
        }
        return result;
    }
}
