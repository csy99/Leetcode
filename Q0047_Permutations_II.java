package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/26/20.
 * <p>
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 */
public class Q047_Permutations_II {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> permuteUnique(int[] nums) {
    if (nums.length == 0) return res;
    Arrays.sort(nums);
    helper(nums, new boolean[nums.length], new ArrayList());
    return res;
  }
  
  private void helper(int[] nums, boolean[] used, List<Integer> cur) {
    if (cur.size() == nums.length) {
      res.add(new ArrayList(cur));
      return;
    }
    int pre = nums[0]-1;
    for (int i = 0; i < nums.length; i++) {
      if (used[i] || nums[i] == pre)
        continue;
      pre = nums[i];
      used[i] = true;
      cur.add(pre);
      helper(nums, used, cur);
      used[i] = false;
      cur.remove(cur.size() - 1);
    }
  }
}
