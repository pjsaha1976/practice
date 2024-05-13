package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    @Test
    void insert()
    {
        //given
        Heap heap = new Heap(5);

        //when
        heap.insert(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(4);
        heap.insert(3);

        //then
        heap.print();
    }

}