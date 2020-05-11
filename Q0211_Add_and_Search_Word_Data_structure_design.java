package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q211_Add_and_Search_Word_Data_structure_design {
class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = (int) (word.charAt(i) - 'a');
            if (cur.children[pos] == null)
                cur.children[pos] = new TrieNode();
            cur = cur.children[pos];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    private boolean find(String word, int idx, TrieNode cur) {
        if (idx == word.length())
            return cur.isWord;
        char c = word.charAt(idx);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (cur.children[j] != null && find(word, idx+1, cur.children[j]))
                    return true;
            }
            return false;
        } else {
            int pos = (int) (c - 'a');
            if (cur.children[pos] == null)
                return false;
            return find(word, idx+1, cur.children[pos]);
        }
    }
}
}
