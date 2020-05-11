package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 3/15/20.
 * <p>
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 */

public class Q325_Maximum_Size_Subarray_Sum_Equals_k {
   /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
      int maxLen = 0;
      int sum = 0;
      HashMap<Integer, Integer> history = new HashMap<>();
      // if the maximal range starts from 0, we need to calculate sum(j) - sum(i - 1).
      history.put(0, -1);
      for(int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (!history.containsKey(sum))
          history.put(sum, i);
        if (history.containsKey(sum - k))
          maxLen = Math.max(maxLen, i - history.get(sum - k));
      }
      return maxLen;
    }
}
