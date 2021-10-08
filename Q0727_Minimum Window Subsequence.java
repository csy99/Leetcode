/***
 * Created by csy99 on 10/8/21.
 */
class Solution {
    public string minWindow(string S, string T) {
        int m = S.length(), n = T.size();
        final int INF = m+1;
        int start = -1;
        int minLen = INF;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = INF;
        for (int i = 0; i <= m; i++) 
            dp[i][0] = i;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= min(i, n); ++j) {
                dp[i][j] = (S.charAt(i-1) == T.charAt(j-1)) ? dp[i - 1][j - 1] : dp[i - 1][j];
            }
            if (dp[i][n] != INF) {
                int len = i - dp[i][n];
                if (minLen > len) {
                    minLen = len;
                    start = dp[i][n];
                }
            }
        }
        return (start != INF) ? S.substr(start, minLen) : "";
    }
}
