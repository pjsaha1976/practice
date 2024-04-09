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
        //insert node at the end of a list

        Node temp;

        //empty list
        if (head == null) {
            head = node;
            this.size++;
            return;
        }

        //travel to the end of the list
        temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        //add node to the end
        temp.next = node;
        this.size++;
        return;
    }
    public void delete(Node node) {
        //empty list
        if (head == null) return;

        //matches the first node - adjust head after removing first node
        if (head.val == node.val) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            size--;
            return;
        }

        //find the node to delete
        Node current = head;
        Node prev = head;
        while (current != null)
        {
            if (current.val == node.val) {
                prev.next = current.next;
                size--;
                return;
            }
            else {
                prev = current;
                current = current.next;
            }

        }
        return;

    }
    public boolean find(Node node) {
        if (head == null) return false; //empty list

        //list with values
        Node current = head;
        while (current != null) {
            if (current.val == node.val) {
                return true;
            }
            current = current.next;
        }

        return false;

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
