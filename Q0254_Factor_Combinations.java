package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/26/20.
 * <p>
 * Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */

public class Q254_Factor_Combinations {
  List<List<Integer>> res = new ArrayList();
  ArrayList<Integer> factor;
  public List<List<Integer>> getFactors(int n) {
    if (n < 2) return res;
    factor = new ArrayList();
    for (int i = 2; i < n; i++) {
      if (n % i == 0)
        factor.add(i);
    }
    helper(0, new ArrayList(), n);
    return res;
  }
  
  private void helper(int idx, ArrayList<Integer> cur, double target) {
    if (target <= 0) 
      return;
    if (target == 1) {
      res.add(new ArrayList(cur));
      return;
    }
    
    for (int i = idx; i < factor.size(); i++) {
      if (factor.get(i) > target) break;
      cur.add(factor.get(i));
      helper(i, cur, target/factor.get(i));
      cur.remove(cur.size()-1);
    }
  }
}
