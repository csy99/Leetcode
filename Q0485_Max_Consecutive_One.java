package Leetcode;

/**
 * Created by csy99 on 10/17/21.
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, cur);
                cur = 0;
            } else {
                cur++;
            }
        }
        res = Math.max(res, cur);
        return res;
    }
}
