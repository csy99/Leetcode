/**
 * Created by csy99 on 5/1/20.
 */
class Solution {
    private static int[][] dp;
    final int range = 10000;
    public int racecar(int target) {
        if (dp == null) {
            // 0 facing right, 1 facing left
            dp = new int[range+1][2];
            for (int t = 1; t <= range; t++) {
                int n = (int)Math.ceil(Math.log(t+1) / Math.log(2));
                if (1 << n == t + 1) {
                    dp[t][0] = n;
                    dp[t][1] = n+1;
                    continue;
                }
                int l = (1<<n) - 1 - t;
                dp[t][0] = n + 1 + Math.min(dp[l][1], dp[l][0] + 1);
                dp[t][1] = n + 1 + Math.min(dp[l][0], dp[l][1] + 1);
                for (int i = 1; i < t; i++) {
                    for (int d = 0; d <= 1; d++) 
                        dp[t][d] = Math.min(dp[t][d], Math.min(
                        dp[i][0] + 2 + dp[t-i][d], dp[i][1] + 1 + dp[t-i][d]));
                }
            }
        }
        return Math.min(dp[target][0], dp[target][1]);
    }
}
