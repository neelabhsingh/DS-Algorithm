package HeapSort.min_heap;
import util.Util;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by neelabhsingh on 18/12/16.
 */
/*
* The name of a class should always be a noun; if it's a verb then your objects are likely to be crappy.
* You want to define a MinHeap class.
* */
public class MinHeap {
    private int [] data;
    private int size;
    public MinHeap(int[] data, boolean copyData) {
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
        int smallestElementIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if(l<size && data[l]< data[smallestElementIndex]){
            smallestElementIndex = l;
        }
        if(r<size && data[r]< data[smallestElementIndex]){
            smallestElementIndex = r;
        }
        if(i!=smallestElementIndex){
            Util.swapArrayElements(data, i, smallestElementIndex);
            heapify(smallestElementIndex);
        }
    }
    public static void reverseSort(int [] data){
        MinHeap heap = new MinHeap(data, false);
        for(int i =heap.getSize()-1; i>=0; i--){
            int nextMin = heap.removeNext();
            data[i] = nextMin;
        }
    }
    public static void reverseSort_v2(int [] data, boolean copyData){
        MinHeap heap = new MinHeap(data, copyData);
        for(int i =heap.getSize()-1; i>=0; i--){
            int nextMin = heap.removeNext();
            data[i] = nextMin;
        }
    }
}
