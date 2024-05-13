package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    void insert() {

        //given
        Trie trie = new Trie();
        trie.insert("about");
        trie.insert("above");
        trie.insert("aloud");

        //when
        boolean result = trie.search("");

        //then
        assertTrue(result);
    }

    @Test
    void startWith() {

        //given
        Trie trie = new Trie();
        trie.insert("about");
        trie.insert("above");
        trie.insert("aloud");

        //when
        boolean result = trie.startsWith("ab");

        //then
        assertTrue(result);
    }

}