/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        int[][] dp = new int[d+1][n+1];
        for (int i = 0; i <= d; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = (int)1e8;
        dp[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            // finish job l+1~r in day i
            for (int r = 1; r <= n; r++) {
                int largest = 0;
                for (int l = r-1; l >= i-1; l--) {  // must have done at least (i-1) jobs in first (i-1) days
                    largest = Math.max(largest, jobDifficulty[l]);
                    dp[i][r] = Math.min(dp[i][r], dp[i-1][l] + largest);
                }
            }
        }
        return dp[d][n];
    }
}
