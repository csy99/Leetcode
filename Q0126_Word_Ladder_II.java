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
    List<List<String>> res = new ArrayList();
    HashMap<String, Integer> level;
    HashMap<String, List<String>> parents;
    String bw;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        bw = beginWord;
        HashSet<String> dict = new HashSet(wordList);
        if (!dict.contains(endWord)) return res;
        dict.remove(endWord);
        dict.remove(beginWord);
        level = new HashMap();
        parents = new HashMap();
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        int len = beginWord.length();
        int step = 0;
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            step++;
            for (int s = 0; s < size; s++) {
                String parent = q.poll();
                char[] arr = parent.toCharArray();
                for (int i = 0; i < len; i++) {
                    char copy = arr[i];
                    for (int c = 'a'; c <= 'z'; c++) {
                        if (c == copy) continue;
                        arr[i] = (char)c;
                        String trans = new String(arr);
                        if (endWord.equals(trans)) {
                            List<String> pList = parents.getOrDefault(endWord, new ArrayList());
                            pList.add(parent);
                            parents.put(endWord, pList);
                            found = true;
                        } else if (level.containsKey(trans) && step < level.get(trans)) {  // same depth
                            List<String> pList = parents.getOrDefault(trans, new ArrayList());
                            pList.add(parent);
                            parents.put(trans, pList);
                        }
                        if (!dict.contains(trans)) continue;
                        dict.remove(trans);
                        q.add(trans);    
                        level.put(trans, step+1);
                        List<String> pList = parents.getOrDefault(trans, new ArrayList());
                        pList.add(parent);
                        parents.put(trans, pList);
                    }
                    arr[i] = copy;
                }
            }
        }
        if (!found) return res;
        List<String> path = new ArrayList();
        path.add(endWord);
        getPath(path, endWord);
        return res;
    }
    
    private void getPath(List<String> path, String word) {
        if (word.equals(bw)) {
            res.add(new ArrayList(path));
            return;
        }
        List<String> pList = parents.get(path.get(0));
        for (String p: pList) {
            path.add(0, p);
            getPath(path, p);
            path.remove(0);
        }
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
