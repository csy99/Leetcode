package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 3/28/20.
 */
public class Q140_Word_Break_II {

  // backtracking, TLE
  List<String> res = new ArrayList();
  public List<String> wordBreak(String s, List<String> wordDict) {
    if (s.length() == 0) return res;
    HashSet<String> dict = new HashSet(wordDict);
    helper(s, 0, new StringBuilder(), dict);
    return res;
  }
  
  private void helper(String s, int idx, StringBuilder cur, HashSet<String> dict) {
    int curLen = cur.length();
    if (idx == s.length()) {
      res.add(cur.deleteCharAt(0).toString());  // remove the preceding " "
      cur.insert(0, " ");
      return;
    }
    for (int i = idx; i < s.length(); i++) {
      int start = idx;
      String wrd = s.substring(start, i+1);
      if (dict.contains(wrd)) {
        cur.append(" ").append(wrd);
        helper(s, i+1, cur, dict);
        cur.setLength(curLen);
      }
    }
  }
    
  // memorization recursion
  HashMap<String, List<String>> map = new HashMap();
  public List<String> wordBreak(String s, List<String> wordDict) {
    HashSet<String> dict = new HashSet(wordDict);
    return wordBreak(s, dict);
  }
  
  // append word to the end of every String in the list
  private List<String> append(List<String> prefix, String word) {
    List<String> res = new ArrayList();
    for (String s: prefix) 
      res.add(s+" "+word);
    return res;
  }
  
  public List<String> wordBreak(String s, HashSet<String> dict) {
    if (map.containsKey(s))
      return map.get(s);
    List<String> ans = new ArrayList();
    if (dict.contains(s)) 
      ans.add(s);
    // this seperates the string at position i
    for (int i = 1; i < s.length(); i++) {
      // check whether the right part is a word
      String right = s.substring(i);
      if (!dict.contains(right)) continue;
      String left = s.substring(0, i);
      List<String> left_ans = append(wordBreak(left, dict), right);
      ans.addAll(left_ans);
    }
    map.put(s, ans);
    return ans;
  }
  
}
