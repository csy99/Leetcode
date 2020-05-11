package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q139_Word_Break {
  // recursion  
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<String>(wordDict);
    HashMap<String, Boolean> inDict = new HashMap();
    return wordBreak(s, dict, inDict);
  }
  
  private boolean wordBreak(String s, Set<String> dict, HashMap<String, Boolean> inDict) {
    if (inDict.containsKey(s))
      return inDict.get(s);
    if (dict.contains(s)) {
      inDict.put(s, true);
      return true;
    }
    for (int end = 0; end < s.length(); end++) {
      String left = s.substring(0, end);
      String right = s.substring(end);
      if (wordBreak(left, dict, inDict) && dict.contains(right)) {
        inDict.put(s, true);
        return true;
      }
    }
    inDict.put(s, false);
    return false;
  }

  // iteration  
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet(wordDict);
    boolean[] inDict = new boolean[s.length()+1];
    inDict[0] = true;  // "" is valid 
    for (int r = 1; r < s.length()+1; r++) {
      for (int l = 0; l < r; l++) {
        if (inDict[l] && dict.contains(s.substring(l, r))) {
          inDict[r] = true;
          break;
        }
      }
    }
    return inDict[s.length()];
  }
}
