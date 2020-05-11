package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q198_House_Robber {
  // rob[n] = max(rob[n-2]+nums[n], rob[n-1])
  public int rob(int[] nums) {
    int prev2 = 0;
    int prev = 0;
    int cur = 0;
    for (int i = 0; i < nums.length; i++) {
      cur = Math.max(prev2 + nums[i], prev);
      prev2 = prev;
      prev = cur;
    }
    return cur;
  }
  
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return n;
        // dp[i][0]: not steal, dp[i][1]: steal
        int[][] dp = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i-1] + dp[i-1][0];
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}
