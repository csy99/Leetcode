package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 *
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Input: [-2,-4],
 * Output: -2
 */
public class Q053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
