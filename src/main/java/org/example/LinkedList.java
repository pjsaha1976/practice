package org.example;

public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        this.size = 0;
    }
    public LinkedList(Node head) {
        this.head = head;
        this.size = 1;
    }
    public Node getHead() {
        return head;
    }
    public int getSize() {
        return size;
    }
    public void insert(Node node) {
        Node temp= head;
        //empty list
        if (temp == null) {
            head = node;
            this.size++;
            return;
        }

        //travel to the end of the list
        while(temp.next != null){
            temp = temp.next;
        }
        //add node to the end
        temp.next = node;
        this.size++;
        return;
    }
    public void delete(Node node) {
        //delete node
    }
    public void find(Node node) {

    }
    public void update(Node node) {

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
