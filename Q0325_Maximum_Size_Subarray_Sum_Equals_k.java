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
        int n = nums.length;
        if (n == 0) return 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (!map.containsKey(sum))
                map.put(sum, i);
            if (map.containsKey(sum-k))
                len = Math.max(len, i-map.get(sum-k));
        }
        return len;
    }
}
