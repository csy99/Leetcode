package Leetcode;

/**
 * Created by csy99 on 5/7/20.
 */
public class Q410_Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i-1] + nums[i-1];
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++)
            dp[1][j] = sum[j];
        for (int i = 2; i <= m; i++) {
            for (int r = i; r <= n; r++) {  // using i groups, there should be at least i elements
                for (int l = 1; l < r; l++) {  // nums[l] is in (i-1)th group 
                    int cur = Math.max(dp[i-1][l], sum[r] - sum[l]);
                    dp[i][r] = Math.min(dp[i][r], cur);
                }
            }
        }
        return dp[m][n];
    }
}
