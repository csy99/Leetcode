package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by csy99 on 3/30/20.
 */
public class Q126_Word_Ladder_II {
  String beginWord;
  List<List<String>> res = new ArrayList();
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    this.beginWord = beginWord;
    HashSet<String> dict = new HashSet(wordList);
    if (!dict.contains(endWord)) return res;
    dict.remove(beginWord);
    dict.remove(endWord);
    
    Queue<String> q = new LinkedList();
    q.offer(beginWord);
    HashMap<String, List<String>> parents = new HashMap();
    HashMap<String, Integer> steps = new HashMap();
    steps.put(beginWord, 1);
    final int len = beginWord.length();
    int step = 0;
    boolean found = false;
    
    while (!q.isEmpty() && !found) {
      step++;
      for (int size = q.size(); size > 0; size--) {
        String word = q.poll();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < len; i++) {
          char c = word.charAt(i);
          String modified = null;
          for (int j = 'a'; j < 'z'; j++) {
            if (j == c) continue;
            sb.setCharAt(i, (char)j);
            modified = sb.toString();
            if (modified.equals(endWord)) {
              List<String> parent = parents.get(modified);
              if (parent == null)
                parent = new ArrayList();
              parent.add(word);
              parents.put(modified, parent);
              found = true;
            } else {
              // not a new word, but another transform with same path length
              if (steps.containsKey(modified) && step < steps.get(modified)) {
                List<String> parent = parents.get(modified);
                if (parent == null)
                  parent = new ArrayList();
                parent.add(word);
                parents.put(modified, parent);
              }
            }
            if (!dict.contains(modified)) continue;
            dict.remove(modified);
            q.offer(modified);
            steps.put(modified, steps.get(word)+1);
            List<String> parent = parents.get(modified);
            if (parent == null)
              parent = new ArrayList();
            parent.add(word);
            parents.put(modified, parent);
          }
          sb.setCharAt(i, c);
        }
        
      }
    }
    if (found) {
      List<String> path = new ArrayList();
      path.add(endWord);
      getPath(endWord, parents, path);
    }
    return res;
  }
  
  private void getPath(String word, HashMap<String, List<String>> parents, List<String> cur) {
    if (word.equals(beginWord)) {
      List<String> tmp = new ArrayList(cur);
      // the list is from end word to begin word (only store parents)
      Collections.reverse(tmp);
      res.add(tmp);
      return;
    }
    List<String> parent = parents.get(word);
    // System.out.println(parent);
    for (String p: parent) {
      cur.add(p);
      getPath(p, parents, cur);
      cur.remove(cur.size()-1);
    }
    
  }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        Q126_Word_Ladder_II sol = new Q126_Word_Ladder_II();
        List<List<String>> ans = sol.findLadders("hit", "cog", list);
        System.out.println(ans);
    }
}
