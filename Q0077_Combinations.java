package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q077_Combinations {
  
  List<List<Integer>> res;
  int n;
  int k;
  
  public List<List<Integer>> combine(int n, int k) {
    this.n = n;
    this.k = k;
    res = new ArrayList();
    if (n == 0 || k == 0) return res;
    helper(new ArrayList(), 1);
    return res;
  }
  
  private void helper(List<Integer> comb, int idx) {
    if (comb.size() == k) {
      res.add(new ArrayList(comb));
      return;
    }
    for (int i = idx; i <= n; i++) {
      comb.add(i);
      helper(comb, i+1);
      comb.remove(comb.size()-1);
    }
  }
}
