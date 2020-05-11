package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q301_Remove_Invalid_Parentheses {
  public List<String> removeInvalidParentheses(String s) {
    int l = 0;
    int r = 0;
    // count invalid left and right parathesis number
    for (char c: s.toCharArray()) {
      if (c == '(') l++;
      if (l == 0 && c == ')') r++;
      else if (l != 0 && c == ')') l--;
    }
    List<String> res = new LinkedList();
    dfs(s, 0, l, r, res);
    return res;
  }
  
  private boolean isValid(String s) {
    int cnt = 0;
    for (char c: s.toCharArray()) {
      if (c == ')') cnt--;
      else if (c == '(') cnt++;
      if (cnt < 0) return false;
    }
    return cnt == 0;
  }
  
  private void dfs(String s, int start, int l, int r, List<String> res){
    if (l == 0 && r == 0) {
      if (isValid(s))
        res.add(s);
      return;
    }
    
    for (int i = start; i < s.length(); i++) {
      char c = s.charAt(i);
      // only remove first parenthesis if there're consecutive ones to avoid duplicate
      if (i > start && c == s.charAt(i-1)) continue;
      String cur = s.substring(0, i) + s.substring(i+1);
      // always remove right parenthesis first (more likely to get a valid seq)
      if (c == ')' && r > 0) 
        dfs(cur, i, l, r-1, res);
      else if (c == '(' && r == 0 && l > 0)
        dfs(cur, i, l-1, r, res);
    }
  }
}
