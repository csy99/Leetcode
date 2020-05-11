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
        // int[] sum = new int[n+1];
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cur = 0;
            if (sum > 0)
                cur = sum + nums[i-1];
            else
                cur = nums[i-1];
            if (cur > res)
                res = cur;
            sum = cur;
        }
        return res;    
    }
}
