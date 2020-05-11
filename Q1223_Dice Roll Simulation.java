/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int kMod = 1_000_000_007;
        int[][] dp = new int[n+1][6];
        int[] sum = new int[n+1];
        
        for (int j = 0; j < 6; j++) 
            dp[1][j] = 1;
        sum[1] = 6;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int k = i - rollMax[j];
                int invalid = 0;
                if (k <= 1)
                    invalid = Math.max(k, 0);
                else
                    invalid = sum[k-1] - dp[k-1][j];
                dp[i][j] = ((sum[i-1] - invalid) % kMod + kMod) % kMod;
                sum[i] = (sum[i] + dp[i][j]) % kMod;
            }
        }
        return sum[n];
    }
}
