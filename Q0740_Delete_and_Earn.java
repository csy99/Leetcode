/**
 * Created by csy99 on 5/1/20.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        int r = 10000;
        int[] dp = new int[r+1];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]]++;
            max = Math.max(max, nums[i]);
        }
        return rob(dp, max);
    }
    
    private int rob(int[] vals, int hi) {
        int rob = 0;
        int nRob = 0;
        for (int i = 1; i <= hi; i++) {
            int new_rob = vals[i] * i + nRob;
            nRob = Math.max(nRob, rob);
            rob = new_rob;
        }
        return Math.max(rob, nRob);
    }
}
