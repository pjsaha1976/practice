package org.example;

import java.util.EmptyStackException;


public class Stack {

    private Node top;
    private int size;
    private int MAX_SIZE;

    public int getSize() {
        return size;
    }

    public Stack(int maxsize)
    {
        this.top = null;
        this.MAX_SIZE = maxsize;
    }

    //push an element
    public void push(Node node)
    {
        //empty stack
        if (this.top == null)
        {
            this.top = node;
            this.size++;
            return;
        }
        //stack has elements
        if (this.size < this.MAX_SIZE) {
            Node temp = this.top;
            this.top = node;
            this.top.next = temp;
            this.size++;
            return;
        }
        else throw new StackOverflowError(" stack is full ");


    }

    //pop an element
    public Node pop()
    {
        //empty tack
        if (this.top == null) {
            throw new EmptyStackException();
        }
        else {
            Node temp = this.top;
            this.top = this.top.next;
            this.size--;
            return temp;
        }

    }

}
