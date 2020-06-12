package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
      int curMin = nums[0];
      int curMax = nums[0];
      int res = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int tmpMin = curMin*nums[i];
        int tmpMax = curMax*nums[i];
        curMin = Math.min(tmpMin, tmpMax);
        curMin = Math.min(curMin, nums[i]);
        curMax = Math.max(tmpMin, tmpMax);
        curMax = Math.max(curMax, nums[i]);
        res = Math.max(curMax, res);
      }
      return res;
    }
}
