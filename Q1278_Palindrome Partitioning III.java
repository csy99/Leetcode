/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = len-1; j < n; i++, j++) {
                cost[i][j] = cost[i+1][j-1];
                if (s.charAt(i) != s.charAt(j))
                    cost[i][j]++;
            }
        }
        final int INF = (int) 1e8;
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = INF;
        for (int r = 0; r < n; r++) {
            dp[r][1] = cost[0][r];
            for (int j = 2; j <= k; j++) {  // # of groups 
                for (int m = 0; m < r; m++)
                    dp[r][j] = Math.min(dp[r][j], dp[m][j-1] + cost[m+1][r]);
            }
        }
        return dp[n-1][k];
    }
}
