package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/20/20.
 * <p>
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 */
public class Q022_Generate_Parentheses {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    helper("", res, n, 0, 0);
    return res;
  }
  
  private void helper(String s, List<String> res, int n, int left, int right) {
    if (right == n) {
      res.add(s);
      return;
    }
    if (left < n) 
      helper(s+"(", res, n, left+1, right);
    if (right < left) 
      helper(s+")", res, n, left, right+1);      
  }
}
