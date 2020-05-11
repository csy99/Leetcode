package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/10/20.
 * <p>
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class Q212_Word_Search_II {
    class TrieNode {
        TrieNode[] children;
        // boolean isWord;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
            // isWord = false;
            word = "";
        }
    }
    
    List<String> res = new ArrayList();
    HashSet<String> dict;
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        if (m == 0) return res;
        n = board[0].length;
        if (n == 0) return res;
        
        TrieNode root = buildTrie(words);
        dict = new HashSet(Arrays.asList(words));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(i, j, board, root);
            }
        }
        return res;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w: words) {
            TrieNode cur = root;
            for (int i = 0; i < w.length(); i++) {
                int pos = (int)(w.charAt(i) - 'a');
                if (cur.children[pos] == null)
                    cur.children[pos] = new TrieNode();
                cur = cur.children[pos];
            }
            cur.word = w;
        }
        return root;
    }
    
    private void find(int y, int x, char[][] board, TrieNode cur) {
        if (y < 0 || y >= m || x < 0 || x >= n || board[y][x] == '*')
            return;
        char ch = board[y][x];
        TrieNode nxt = cur.children[(int)(ch - 'a')];
        // not a valid word
        if (nxt == null)
            return;
        // update the result list
        if (dict.contains(nxt.word)) { 
            res.add(nxt.word);
            dict.remove(nxt.word);
        }
        board[y][x] = '*';
        find(y-1, x, board, nxt);
        find(y+1, x, board, nxt);
        find(y, x-1, board, nxt);
        find(y, x+1, board, nxt);
        board[y][x] = ch;
        return;
    }
}
