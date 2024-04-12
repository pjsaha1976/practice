package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    @Test
    void LCS(){
        //given
        String a = "abcde";
        String b = "cde";

        //when
        int count = Algorithm.LCS(a,b);

        //then
        assertEquals(3,count);

    }

}