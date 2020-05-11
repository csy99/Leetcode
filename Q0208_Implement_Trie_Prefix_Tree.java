package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q208_Implement_Trie_Prefix_Tree {
class Trie {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = (int)(word.charAt(i) - 'a');
            if (p.children[pos] == null)
                p.children[pos] = new TrieNode();
            p = p.children[pos];
        }
        p.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = (int)(word.charAt(i) - 'a');
            if (p.children[pos] == null)
                return false;
            p = p.children[pos];
        }
        return p.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = (int)(prefix.charAt(i) - 'a');
            if (p.children[pos] == null)
                return false;
            p = p.children[pos];
        }
        return true;
    }
}
}


