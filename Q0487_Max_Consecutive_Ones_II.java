package Leetcode;

/**
 * Created by csy99 on 10/17/21.
 */
// counting, time: O(n), space: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int cur = 0;
        int zeros = 2;
        int pre = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cur++;
                continue;
            } else if (i > 0 && nums[i-1] == 0) {
                zeros++;
                continue;
            }
            // the first zero after consecutive ones
            if (zeros > 1) 
                res = Math.max(res, cur + 1);
            else
                res = Math.max(res, pre + cur + zeros);
            zeros = 1;
            pre = cur;
            cur = 0;
        }
        if (zeros > 1) 
            res = Math.max(res, cur + 1);
        else
            res = Math.max(res, pre + cur + zeros);
        return Math.min(n, Math.max(1, res));
    }
}

// dp, time: O(n), space: O(1)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int dp0 = 0;
        int dp1 = 0;  // used the chance to flip
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                dp0++;
                dp1++;
            } else {
                dp1 = dp0 + 1;
                dp0 = 0;
            }
            res = Math.max(res, Math.max(dp0, dp1)); 
        }
        return res;
    }
}
