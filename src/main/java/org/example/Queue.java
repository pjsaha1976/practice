package org.example;

import java.util.NoSuchElementException;

public class Queue {
    private Node head; //head of the queue
    private int size; //size of the queue

    public Queue() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(Node node)
    {
        Node temp = head;

        //empty queue
        if (head == null) {
            head = node;
            size++;
            return;
        }

        //non empty queue
        while (temp.next != null)  temp = temp.next;
        temp.next = node;
        size++;
        return;
    }

    public Node dequeue(){
        if (head == null) return null; //empty queue

        //queue has elements
        Node temp = head;
        head = head.next;
        size--;
        return temp;

    }
}
