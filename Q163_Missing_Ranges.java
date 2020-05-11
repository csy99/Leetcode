package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/15/20.
 * <p>
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->100”]
 *
 * Input:
 * nums = [0, 1, 2, 3, 7], lower = 0 and upper = 7
 * Output ["4->6"]
 * Explanation:
 * in range[0,7],the missing range include range[4,6]
 */
public class Q163_Missing_Ranges {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
      ArrayList<String> res = new ArrayList<>();
      long lo = (long) lower;
      long hi = (long) upper;
      if (nums.length == 0) {  // the whole range is missing
        fill(res, lo-1, hi+1);
        return res;
      }
      fill(res, lo-1, nums[0]);
      for (int i = 1; i < nums.length; i++) {
        fill(res, nums[i-1], nums[i]);
      }
      fill(res, nums[nums.length-1], hi+1);
      return res;
    }
    
    /**
     * fill range between lo and hi (exclusively)
     */
    private void fill(List<String> res, long lo, long hi) {
      if (lo == hi || lo + 1 == hi)
        return;
      StringBuilder sb = new StringBuilder();
      if (lo + 2 == hi) {
        sb.append(lo + 1);
      } else {
        sb.append(lo + 1);
        sb.append("->");
        sb.append(hi - 1);
      }
      res.add(sb.toString());
    }
}
