package practice1.heap;

import java.util.Arrays;

/**
 * Created by neelabhsingh on 20/01/17.
 */
public class MaxHeap {
    private int maxSize;
    int [] array;
    MaxHeap(int maxSize, int [] array){
        this.maxSize = maxSize;
        array = Arrays.copyOf(array, array.length);
    }
    public int getMaxSize(){
        return maxSize;
    }
    private int getLeftChild(int i){
        return i*2+1;
    }
    private int getRightChild(int i){
        return i*2+2;
    }
    public int getSize(){
        return array.length;
    }
    private void heapify(int i){
        int largestElement =i;
        int leftIndex = getLeftChild(i);
        int rightIndex = getRightChild(i);
        if(leftIndex<getSize() && array[largestElement]> array[leftIndex]){
            largestElement = leftIndex;
        }
        if(rightIndex<getSize() && array[largestElement]<array[rightIndex]){
            largestElement = rightIndex;
        }
        if(largestElement!=i){
            int temp = array[largestElement];
            array[largestElement] = array[i];
            array[i] = temp;
            heapify(largestElement);
        }
    }
}
