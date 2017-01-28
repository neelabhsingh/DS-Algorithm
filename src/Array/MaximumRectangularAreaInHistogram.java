package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by neelabhsingh on 27/01/17.
 */
/**
 *Find the largest rectangular area possible in a given histogram where the largest
 * rectangle can be made of a number of contiguous bars.
*/
public class MaximumRectangularAreaInHistogram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-->0){
            int size = Integer.parseInt(br.readLine());
            String [] str = br.readLine().split(" ");
            int [] histogram = new int[size];
            for(int i=0; i<size;i++){
                histogram[i] = Integer.parseInt(str[i]);
            }
            System.out.println(getMaxReactangularArea(histogram));
        }
    }
    public static int getMaxReactangularArea(int [] histogram){
        int size = histogram.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while (i<size){
            if(stack.isEmpty() || histogram[stack.peek()] <=histogram[i]){
                stack.push(i);
                i++;
            }else {
                int index = stack.pop();
                maxArea = Math.max(maxArea,histogram[index]* (stack.isEmpty()?i: i-stack.peek()-1));
            }
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            maxArea = Math.max(maxArea,histogram[index]* (stack.isEmpty()?i: i-stack.peek()-1));
        }
        return maxArea;
    }
}
