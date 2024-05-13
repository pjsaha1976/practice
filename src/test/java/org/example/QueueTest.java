package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue(Node node) {
        //given
        Queue queue = new Queue();

        //when
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));
        queue.enqueue(new Node(5));
        queue.enqueue(new Node(0));

        //then
        assertEquals(4,queue.getSize());
    }

    @Test
    void dequeue() {
        //given
        Queue queue = new Queue();
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));
        queue.enqueue(new Node(5));
        queue.enqueue(new Node(0));

        //when
        Node node = queue.dequeue();

        //then
        assertEquals(1,node.val);


    }

}