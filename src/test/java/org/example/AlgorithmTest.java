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

    @Test
    void topKString()
    {
        //given
        String[] arr = {"ab", "abc", "abcd", "xyz", "b", "a", "a", "xyz", "xyz", "xyz", "b"};

        //when
        String[] result = Algorithm.topKString(arr,3);

        //then
        for (String s : result){
            System.out.println(s);
        }
    }

}