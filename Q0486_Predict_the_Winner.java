package Leetcode;

/**
 * Created by csy99 on 5/20/21.
 */
public class Q486_Predict_the_Winner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int len=1; len <= n; len++) {
            int[] cur = new int[n];
            for (int i = 0; i+len-1 < n; i++) {
                int j = i+len-1;
                if (len == 1)
                    cur[j] = nums[i];
                else
                    cur[j] = Math.max(nums[i]-dp[j], nums[j]-dp[j-1]);
            }
            dp = cur;
        }
        return dp[n-1] >= 0;
    }
}
