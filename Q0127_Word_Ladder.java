package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by csy99 on 3/29/20.
 */
public class Q127_Word_Ladder {
  // BFS
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> dict = new HashSet(wordList);
    if (!dict.contains(endWord)) return 0;
    Queue<String> q = new LinkedList();
    q.offer(beginWord);
    int step = 0;
    int len = beginWord.length();
    while (q.size() > 0) {
      step++;
      for (int size = q.size(); size > 0; size--) {
        // original words
        StringBuilder w = new StringBuilder(q.poll());
        for (int i = 0; i < len; i++) {  // change char in every position
          char cur = w.charAt(i);
          for (int c = 'a'; c <= 'z'; c++) {
            w.setCharAt(i, (char) c);
            String newWord = w.toString();
            if (endWord.equals(newWord))
              return step+1;
            if (!dict.contains(newWord))
              continue;
            dict.remove(newWord);  // no need to use twice (further distance if used more than once)
            q.offer(newWord);
          }
          w.setCharAt(i, cur);
        }
      }
    }
    
    return 0;  // fail to find a path
  }

  // Bidirectional BFS
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> dict = new HashSet(wordList);
    if (!dict.contains(endWord)) return 0;
    HashSet<String> head = new HashSet();
    head.add(beginWord);
    HashSet<String> tail = new HashSet();
    tail.add(endWord);
    int step = 0;
    int len = beginWord.length();
    while (head.size() > 0 && tail.size() > 0) {
      step++;
      // always expend the smaller queue first
      if (head.size() > tail.size()) {
        HashSet<String> tmp = head;
        head = tail;
        tail = tmp;
      }
      HashSet<String> q = new HashSet();
      for (String str: head) {
        // original words
        StringBuilder w = new StringBuilder(str);
        for (int i = 0; i < len; i++) {  // change char in every position
          char cur = w.charAt(i);
          for (int c = 'a'; c <= 'z'; c++) {
            w.setCharAt(i, (char) c);
            String newWord = w.toString();
            if (tail.contains(newWord))
              return step+1;
            if (!dict.contains(newWord))
              continue;
            dict.remove(newWord);  // no need to use twice (further distance if used more than once)
            q.add(newWord);
          }
          w.setCharAt(i, cur);
        }
      }
      head = q;
    }
    
    return 0;  // fail to find a path
  }
    
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"});
        Q127_Word_Ladder sol = new Q127_Word_Ladder();
        int ans = sol.ladderLength("hit", "cog", list);
        System.out.println(ans);
    }
}
