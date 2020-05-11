package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q216_Combination_Sum_III {
  // backtracking 
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> combinationSum3(int k, int n) {
    if (k == 0 || n == 0 || k > n) return res;
    sumHelper(new ArrayList(), k, n, 1);
    return res;
  }
  
  private void sumHelper(List<Integer> cur, int k, int n, int num) {
    if (n == 0 && k == 0) {
      res.add(new ArrayList(cur));
      return;
    }
    for (int i = num; i < 10; i++) {
      if (i > n) break;
      cur.add(i);
      sumHelper(cur, k-1, n-i, i+1);
      cur.remove(cur.size()-1);
    }
  }
}
