package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by neelabhsingh on 20/01/17.
 */
/**
 * Numbers are generated and passed to a method.
 * Write a program to find and maintain the median value as new values are generated.
* */
public class MedianValueOfNewValues {
    public static void main(String[] args) throws IOException{
        Median median = new Median();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int value = Integer.parseInt(br.readLine());
            median.addNewNumber(value);
            System.out.println("Median: "+ median.getMedian());
        }
    }
}
class Median{
    PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void addNewNumber(int randomNumber){
        //If both maxHeap and minHeap are equal.
        if(maxPriorityQueue.size() == minPriorityQueue.size()){
            //when size is not zero;
            if(maxPriorityQueue.peek()!=null && randomNumber> minPriorityQueue.peek()){
                maxPriorityQueue.offer(minPriorityQueue.poll());
                minPriorityQueue.offer(randomNumber);
            }else {
                maxPriorityQueue.offer(randomNumber);
            }
        }else {
            if(randomNumber < maxPriorityQueue.peek()){
                minPriorityQueue.offer(maxPriorityQueue.poll());
                maxPriorityQueue.offer(randomNumber);

            }else {
                minPriorityQueue.offer(randomNumber);
            }
        }
    }
    public double getMedian(){
        if(maxPriorityQueue.size()==0){
            return 0;
        }
        if(maxPriorityQueue.size() == minPriorityQueue.size()){
            return (maxPriorityQueue.peek()+ minPriorityQueue.peek())/2d;
        }else {
            return maxPriorityQueue.peek();
        }
    }
}