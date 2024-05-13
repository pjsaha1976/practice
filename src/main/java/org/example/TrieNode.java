package org.example;

import java.util.ArrayList;

public class TrieNode {
    char val;
    ArrayList<TrieNode> children;
    boolean isWord;

    public TrieNode(char val) {
        this.val = val;
        this.children = new ArrayList<>();
        this.isWord = false;
    }
}
