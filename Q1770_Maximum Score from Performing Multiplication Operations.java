/**
 * Created by csy99 on 2/21/21.
 */
// time: O(m^2), space: O(m^2)
class Solution {
    int n = 0;
    int m = 0;
    Integer[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        dp = new Integer[m][m];
        return helper(nums, multipliers, 0, 0);
    }
    
    private int helper(int[] nums, int[] multis, int start, int idx) {
        if (idx >= m) return 0;
        if (dp[start][idx] != null) return dp[start][idx];
        int front = helper(nums, multis, start+1, idx+1) + nums[start]*multis[idx];
        int back = helper(nums, multis, start, idx+1) + nums[n-(idx-start)-1]*multis[idx];
        return dp[start][idx] = Math.max(front, back);
    }
}
