package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q078_Subsets {
  // backtracking
  // time: O(n*2^n), space: O(n*2^n)
  List<List<Integer>> res = new ArrayList();
  
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> cur = new ArrayList();
    for (int n = 0; n <= nums.length; n++) {
      backtrack(nums, cur, 0, n);
    }
    return res;
  }
  
  // size: num of elements in the list cur
  // start: start idx in nums (for combination problems, always let smaller idx appears first)
  private void backtrack(int[] nums, List<Integer> cur, int start, int size) {
    if (size == cur.size()) {
      res.add(new ArrayList(cur));
      return;
    }
    
    for (int idx = start; idx < nums.length; idx++) {
      cur.add(nums[idx]);
      backtrack(nums, cur, idx+1, size);
      cur.remove(cur.size()-1);
    }
  }
}
