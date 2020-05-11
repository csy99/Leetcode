package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 */
public class Q213_House_Robber_II {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    
    int prev2_rf = 0;
    int prev_rf = 0;
    int res_rf = 0;
    
    int prev2_nrf = 0;
    int prev_nrf = 0;
    int res_nrf = 0;
    
    for (int i = 0; i < nums.length; i++) {
      if (i != nums.length - 1) {
        res_rf = Math.max(prev2_rf + nums[i], prev_rf);
        prev2_rf = prev_rf;
        prev_rf = res_rf;
      }
      
      if (i > 0) {
        res_nrf = Math.max(prev2_nrf + nums[i], prev_nrf);
        prev2_nrf = prev_nrf;
        prev_nrf = res_nrf;
      }
    }
    
    return Math.max(res_rf, res_nrf);
  }
  
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];  // corner case
        // dp[i]: 0 not stealing head, not stealing this; 1 not stealing head, stealing this;
        // 2 stealing head, not stealing this; 3 stealing head, stealing this
        int[][] dp = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            if (i != 1) {
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
                dp[i][1] = nums[i-1] + dp[i-1][0];
            }
            if (i != n) {
                dp[i][2] = Math.max(dp[i-1][3], dp[i-1][2]);
                dp[i][3] = nums[i-1] + dp[i-1][2];
            } else {
                dp[i][2] = dp[i-1][2];
                dp[i][3] = dp[i-1][3];
            }
        }
        int profit = dp[n][0];
        for (int j = 1; j < 4; j++) 
            profit = Math.max(profit, dp[n][j]);
        return profit;
    }
}
