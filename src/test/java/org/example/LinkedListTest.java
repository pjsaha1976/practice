package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getHead() {
    }

    @Test
    void insert() {
        LinkedList list = new LinkedList(new Node(10));
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.insert(new Node(40));
        assertEquals(4,list.getSize());
    }

    @Test
    void delete() {
    }

    @Test
    void find() {
    }

    @Test
    void update() {
    }

    @Test
    void print() {
    }
}