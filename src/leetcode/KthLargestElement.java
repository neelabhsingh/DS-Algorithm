package leetcode;


import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by neelabhsingh on 18/12/16.
 */


public class KthLargestElement {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] dataStr = br.readLine().split(" ");
        int [] data = new int[dataStr.length];
        int i =0;
        for(String str: dataStr){
            data[i] = Integer.parseInt(str);
            i++;
        }
        System.out.print(MaxHeap.findKthLargest(data, 1));
    }
}
class MaxHeap {
    private int [] data;
    private int size;
    public MaxHeap(int[] data) {
        this.size = data.length;
        this.data = data;
        for(int i=this.size/2-1; i>=0; i--){
            heapify(i);
        }
    }
    public int removeNext(){
        int next = data[0];
        data[0] = data[--size];
        heapify(0);
        return next;
    }
    public int getSize() {
        return this.size;
    }
    private int leftChild(int i){
        return 2*i+1;
    }
    private int rightChild(int i){
        return 2*i+2;
    }
    private void heapify(int i){
        int largestElementIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if(l<this.size && data[l]> data[largestElementIndex]){
            largestElementIndex = l;
        }
        if(r<this.size && data[r]> data[largestElementIndex]){
            largestElementIndex = r;
        }
        if(i!=largestElementIndex){
            int temp = data[i];
            data[i] = data[largestElementIndex];
            data[largestElementIndex] = temp;
            heapify(largestElementIndex);
        }
    }
    public static void sort(int [] data){
        MaxHeap heap = new MaxHeap(data);
        for(int i =heap.getSize()-1; i>=0; i--){
            int nextMax = heap.removeNext();
            data[i] = nextMax;
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(nums);
        int result = -1;
        for(int i=0; i<k; i++){
            result = maxHeap.removeNext();
        }
        return result;
    }
}
