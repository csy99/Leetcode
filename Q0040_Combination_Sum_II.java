package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q040_Combination_Sum_II {
  // time: O(2^n)
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates.length == 0 || target == 0) return res;
    Arrays.sort(candidates);
    sumHelper(candidates, target, 0, true, new ArrayList());
    return res;
  }
  
  private void sumHelper(int[] nums, int target, int idx, boolean taken, List<Integer> cur) {
    if (target == 0) {
      res.add(new ArrayList(cur));
      return;
    }
    
    for (int i = idx; i < nums.length; i++) {
      if (nums[i] > target) break;
      if (i != idx && nums[i] == nums[i-1]) continue;
      cur.add(nums[i]);
      sumHelper(nums, target-nums[i], i+1, true, cur);
      cur.remove(cur.size()-1);
    }
  }
}
