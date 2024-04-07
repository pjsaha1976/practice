package org.example;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @org.junit.jupiter.api.Test
    void getArr() {
    }

    @org.junit.jupiter.api.Test
    void insert() {
        int[] intArray = {1, 2, 4, 5, 6, 7, 8, 9, 10};
        Array arr = new Array(intArray);
        arr.insert(3,2);
        assertEquals(3, arr.getArr()[2]);

    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void print() {
    }
}