package org.example;

import java.util.ArrayList;
import java.util.Arrays;

//min heap
public class Heap {
    private int size;
    private int capacity;
    private int[] array;

    public Heap(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    private int getParentIndex(int index){
            return (index - 1) / 2;
    }
    private int getLeftChildIndex(int index){
        return (2*index) + 1;
    }
    private int getRightChildIndex(int index){
        return (2*index) + 2;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
    private int rightChild(int index){
        return(array[getRightChildIndex(index)]);
    }
    private int leftChild(int index){
        return(array[getLeftChildIndex(index)]);
    }
    private int parent(int index){
        return(array[getParentIndex(index)]);
    }
    private boolean isHeapFull(){
        return (size==capacity);
    }
    private boolean isHeapEmpty(){
        return (size==0);
    }
    private void ensureExtraCapacity(){
        if (size==capacity){
            capacity *= 2;
            array = Arrays.copyOf(array,capacity);
        }
    }
    private void swap(int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //insert
    public void insert(int value){

        //empty heap
        if (isHeapEmpty()) {
            array[0] = value;
            size++;
            return;
        }

        //heap full
        if (isHeapFull()) {
            ensureExtraCapacity();
        }

        //heap has capacity
        array[size] = value; //insert at the end of the array
        size++;
        //heapifyUp
        heapifyUp(size - 1);

    }

    private void heapifyUp(int index) {
        while (hasParent(index) && (array[index] < parent(index))){
            //swap child with parent
            swap(index, getParentIndex(index));
            //set  index to parent
            index = getParentIndex(index);
        }
    }

    public void print(){
        for (int i=0; i<size; i++){
            System.out.print(array[i]+" ");
        }
    }

}
