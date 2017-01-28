package geeksforgeeks.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neelabhsingh on 19/01/17.
 */
class Index{
    int index;
}
public class PreOrderToPostOrder {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arrayPre = br.readLine().split(" ");
        int size =arrayPre.length;
        int [] preOrder= new int[size];
        for(int i=0; i<size; i++){
            preOrder[i] = Integer.parseInt(arrayPre[i]);
        }
        int [] array = new int[size];
        Index index = new Index();
        index.index =0;
        getPostOrder(preOrder, 0, size-1, array, index);
        for(int value: array){
            System.out.print(value+" ");
        }
    }
    public static void getPostOrder(int [] pre, int start, int end, int [] array, Index index){
        if(start> end){
            return;
        }
        int value = pre[start];
        int elementIndex = getElementIndex(pre, start+1, end, value);

    }
    public static int getElementIndex(int []pre, int start, int end, int value){
        for(int i=start; i<=end; i++){
            if(pre[i] > value){
                return i-1;
            }
        }
        return -1;
    }
}
