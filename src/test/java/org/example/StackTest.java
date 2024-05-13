package org.example;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push()
    {
        //given
        Stack stack = new Stack(5);

        //when
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(6));
        stack.push(new Node(4));

        //then
        assertEquals(4,stack.getSize());

    }

    @Test
    void pop()
    {
        //given
        Stack stack = new Stack(5);
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(6));
        stack.push(new Node(4));

        //when

        try {
            Node node = stack.pop();
            //then
            assertEquals(4,node.val);
        }
        catch (EmptyStackException e) {
            System.out.println(e);
            assertEquals(0,stack.getSize());
        }



    }

}