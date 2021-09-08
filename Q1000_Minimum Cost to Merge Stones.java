/**
 * Created by csy99 on 9/7/21.
 */
class Solution {
    // dp, time: O(n^3/K), space: O(n^2)
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if (n == 1) return 0;
        if ((n-1) % (K-1) != 0) return -1;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + stones[i];
        int[][] dp = new int[n][n];
        for (int len = K; len <= n; len++) {
            for (int i = 0; i+len <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int cut = i; cut < j; cut += K-1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][cut] + dp[cut+1][j]);
                if ((len-1) % (K-1) == 0)
                    dp[i][j] += sum[j+1] - sum[i];
            }
        }
        return dp[0][n-1];
    }
    
}
