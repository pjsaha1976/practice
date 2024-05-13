package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void insert() {
        LinkedList list = new LinkedList(new Node(10));
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.insert(new Node(40));
        list.print();
        assertEquals(4,list.getSize());
    }

    @Test
    void delete() {
        //given
        LinkedList list = new LinkedList(new Node(10));
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.insert(new Node(40));
        //when
        list.delete(new Node(10));
        list.delete(new Node(20));
        list.print();

        //then
        assertEquals(2.,list.getSize());
    }

    @Test
    void find() {
        //given
        LinkedList list = new LinkedList(new Node(10));
        list.insert(new Node(20));
        list.insert(new Node(30));
        list.insert(new Node(40));

        //when
        boolean result = list.find(new Node(10));

        //then
        assertTrue(result);
    }
}