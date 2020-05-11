package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q039_Combination_Sum {
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates.length == 0 || target == 0) return res;
    Arrays.sort(candidates);
    sumHelper(candidates, target, 0, new ArrayList());
    return res;
  }
  
  private void sumHelper(int[] nums, int target, int idx, List<Integer> cur) {
    if (target == 0) {
      res.add(new ArrayList(cur));
      return;
    }
    for (int i = idx; i < nums.length; i++) {
      if (nums[i] > target) break;
      cur.add(nums[i]);
      sumHelper(nums, target - nums[i], i, cur);
      cur.remove(cur.size()-1);
    }  
  }
    
}
