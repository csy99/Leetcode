/**
 * Created by csy99 on 5/5/20. 
 */
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int max = -1;
            for (int k = 1; k <= Math.min(i, K); k++) {
                max = Math.max(max, A[i-k]);
                dp[i] = Math.max(dp[i], dp[i-k] + k*max);
            }
        }
        return dp[n];
    }
}
