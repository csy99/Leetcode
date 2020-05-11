package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
      if (nums == null || nums.length == 0)
        return 0;
      int leng = Integer.MAX_VALUE;
      int sum = 0;
      int l = 0;
      int r = 0;
      while (r < nums.length) {
        sum += nums[r];
        while (sum >= s) {
          leng = Math.min(leng, r - l + 1);
          sum -= nums[l++];
        }
        r++;
      }
      return leng == Integer.MAX_VALUE ? 0 : leng;
    }
}
