package org.example;

//example linked list implementation
//more test for PR

ublic class LinkedList {

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
        if (head == null) return;
        //delete head node
        if (head.val == node.val) {
            head = head.next;
            size--;
            return;
        }
        //delete other nodes
        Node current = head;
        Node prev = head;
        while (current != null) {
            if (current.val == node.val) { //item found
                prev.next = current.next;
                size--;
                return;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    public boolean find(Node node) {
        if (head == null) return false;
        Node temp = head;
        while (temp != null){
            if (temp.val == node.val) return true;
            else temp = temp.next;
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
