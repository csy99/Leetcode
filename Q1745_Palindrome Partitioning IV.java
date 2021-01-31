/**
 * Created by csy99 on 1/30/2021 during contest. 
 */
class Solution {
    public boolean checkPartitioning(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int s = 0; s+len-1 < n; s++) {
                int e = s + len - 1;
                if (arr[s] == arr[e]) {
                    if (len == 2 || dp[s+1][e-1])
                        dp[s][e] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dp[0][i]) continue;
            for (int j = i+1; j < n; j++) {
                if (!dp[i+1][j]) continue;
                if (dp[j+1][n-1])
                    return true;
            }
        }
        return false;
    }
}
