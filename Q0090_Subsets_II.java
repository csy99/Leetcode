package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 */
public class Q090_Subsets_II {
  
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums.length == 0) return res;
    Arrays.sort(nums);
    helper(nums, 0, true, new ArrayList());
    return res;
  }
  
  // get rid of the case that we have not taken the previous element, but we take the current one, 
  // when this two elements are equal
  // e.g.: [2, 2']
  // valid: -,-  2,-   2,2'
  // invalid: -,2'
  private void helper(int[] nums, int idx, boolean taken, List<Integer> subset) {
    if (nums.length == idx) {
      res.add(new ArrayList(subset));
      return;
    }
    helper(nums, idx+1, false, subset);  // not choosing this element
    if (taken || nums[idx] != nums[idx-1]) { // choosing this element
      subset.add(nums[idx]);
      helper(nums, idx+1, true, subset);  // not choosing this element
      subset.remove(subset.size()-1);
    }
  }
}
