/**
 * Created by csy99 on 9/26/20.
 */
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int kInf = (int) 1e9;
        int m = cost.size();
        if (m == 0) return 0;
        int n = cost.get(0).size();
        int[][] dp = new int[m+1][1<<n];
        for (int i = 0; i <= m; i++) 
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = kInf;
        dp[0][0] = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                for (int s = 0; s < 1 << n; s++) {
                    dp[i+1][s | (1<<j)] = Math.min(dp[i+1][s | (1<<j)], 
                                                  Math.min(dp[i+1][s] + cost.get(i).get(j),
                                                          dp[i][s] + cost.get(i).get(j)));
                }
            }
        return dp[m][(1<<n) - 1];
    }
}
