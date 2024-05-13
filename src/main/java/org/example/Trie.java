package org.example;

public class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode('*');
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode current = root;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            found = false;
            for (TrieNode node : current.children) {
                if (node.val == c) {
                    current = node;
                    found = true;
                    break;
                }
            }
            if (!found) {return false;}
        }

       if (found) { //prefix found
        return checkForWord(current,0);
       }
       else {return false;}
    }

    private boolean checkForWord(TrieNode current, int count) {
        if (current.isWord) count++;
        for (TrieNode child : current.children) {
            return checkForWord(child, count);
        }
        if (count > 0) return true;
        else return false;
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode current = root;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            found = false;
            for (TrieNode node : current.children) {
                if (node.val == c) {
                    current = node;
                    found = true;
                    break;
                }
            }
            if (!found) {return false;}
        }

        return (found && current.isWord);
    }
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < arr.length; i++) {
            //check if the char node already exist
            boolean charFound = false;
            for (TrieNode node : current.children) {
                if (node.val == arr[i]) {
                    current = node;
                    charFound = true;
                    break;
                }
            }
            //otherwise add it and mark it as word if it is the final character of a given word
            if (!charFound) {
                TrieNode newNode = new TrieNode(arr[i]);
                current.children.add(newNode);
                current = newNode;
            }

        }
        //mark current node as word
        current.isWord = true;
        return;

    }
}
