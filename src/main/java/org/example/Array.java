package org.example;

public class Array {

    private int[] arr;

    public Array(int[] arr) {
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void insert(int val, int pos){
        int[] temp = new int[arr.length + 1];
        for (int i=0; i<pos;i++){
            temp[i] = arr[i];
        }
        temp[pos] = val;
        for (int i=pos; i<arr.length; i++){
            temp[i+1] = arr[i];
        }
        arr = temp;
    }

    public void update(int val, int pos) {
        arr[pos] = val;
    }

    public void delete(int pos) {
        int[] temp = new int[arr.length - 1];
        for (int i=0;i<pos;i++) {
            temp[i]=arr[i];
        }
        for (int i=pos+1;i<arr.length;i++){
            temp[i-1]=arr[i];
        }
        arr = temp;
    }

    public void print(){
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
