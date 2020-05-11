package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/26/20.
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 */
public class Q046_Permutations {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) return res;
    HashSet<Integer> used = new HashSet();
    helper(nums, used, new ArrayList<Integer>());
    return res;
  }
  
  private void helper(int[] nums, HashSet<Integer> used, ArrayList<Integer> cur) {
    if (cur.size() == nums.length) {
      res.add(new ArrayList(cur));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used.contains(nums[i])) 
        continue;
      int last = nums[i];
      used.add(last);
      cur.add(last);
      helper(nums, used, cur);
      used.remove(last);
      cur.remove(cur.size() - 1);
    }
  }
}
