package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by neelabhsingh on 28/01/17.
 */
/**
 * Given a collection of Intervals,merge all the overlapping Intervals.
 * */
public class MergeOverlappingIntervals {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int N = 0;
            String size="";
            try {
                size = br.readLine();
                N = Integer.parseInt(size);
            }catch (Exception ex) {
                String [] numbers = size.split(" ");
                N = Integer.parseInt(numbers[0]);
            }
            String [] array = br.readLine().split(" ");
            Interval [] intervals = new Interval[N];
            int j=0;
            for(int i=0; i<N*2;){
                int x =  Integer.parseInt(array[i++]);
                int y =  Integer.parseInt(array[i++]);
                intervals[j] = new Interval(x, y);
                j++;
            }
            Stack<Interval> stack = getOverLappedIntervals(intervals);
            int newSize = stack.size();
            int k = newSize-1;
            Interval [] result = new Interval[newSize];
            while (!stack.isEmpty()){
                Interval tempInterval = stack.pop();
                result[k] = tempInterval;
                k--;
            }
            for(int i=0; i<newSize; i++) {
                System.out.print(result[i].getStart()+" "+result[i].getEnd()+" ");
            }
            System.out.println();
        }
    }


    public static Stack<Interval> getOverLappedIntervals(Interval [] interval) {
        int size= interval.length;
        Arrays.sort(interval, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() - o2.getStart();
            }
        });
        Stack<Interval> stack = new Stack<>();
        for(int i=0; i<size; i++){
            if(stack.isEmpty() || stack.peek().getEnd() < interval[i].getStart()){
                stack.push(interval[i]);
            }else {
                if(stack.peek().getEnd() <interval[i].getEnd()){
                    Interval tempInterval = stack.pop();
                    tempInterval.setEnd(interval[i].getEnd());
                    stack.push(tempInterval);
                }
            }
        }
        return stack;
    }
}
class Interval{
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
