package HeapSort.max_heap;

import util.Util;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by neelabhsingh on 18/12/16.
 */
/*
* The name of a class should always be a noun; if it's a verb then your objects are likely to be crappy.
* You want to define a MaxHeap class.
* */
public class MaxHeap {
    private int [] data;
    private int size;
    public MaxHeap(int[] data, boolean copyData) {
        this.data = copyData? Arrays.copyOf(data, data.length): data;
        this.size = data.length;
        for(int i=this.size/2-1; i>=0; i--){
            heapify(i);
        }
    }
    public int removeNext() throws NoSuchElementException{
        if(this.size == 0){
            throw new NoSuchElementException();
        }
        int next = data[0];
        data[0] = data[--size];
        heapify(0);
        return next;
    }
    public int extractMax(){
        if(size ==0){
            return Integer.MAX_VALUE;
        }
        int item = data[0];
        data[0] = data[size-1];
        heapify(0);
        size--;
        return item;
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
            Util.swapArrayElements(data, i, largestElementIndex);
            heapify(largestElementIndex);
        }
    }
    public static void sort(int [] data){
        MaxHeap heap = new MaxHeap(data, false);
        for(int i =heap.getSize()-1; i>=0; i--){
            int nextMax = heap.removeNext();
            data[i] = nextMax;
        }
    }
    public static void sort_v2(int [] data, boolean copyData){
        MaxHeap heap = new MaxHeap(data, copyData);
        for(int i =heap.getSize()-1; i>=0; i--){
            int nextMax = heap.removeNext();
            data[i] = nextMax;
        }
    }
}
