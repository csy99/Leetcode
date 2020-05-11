/**
 * Created by csy99 on 5/8/20. 
 */
class Solution {
    public int videoStitching(int[][] clips, int T) {
        final int INF = 1000;
        if (T > 0 && clips.length == 0) return -1;
        int[][] dp = new int[T+1][T+1];
        for (int i = 0; i <= T; i++) {
            for (int j = 0; j <= T; j++)
                dp[i][j] = INF;
        }
        for (int[] clip: clips) {
            int start = clip[0];
            int end = clip[1];
            for (int len = 1; len <= T; len++) {
                for (int i = 0; i+len <= T; i++) {
                    int j = i + len;
                    if (start > j || end < i) 
                        continue;
                    if (start <= i && end >= j) 
                        dp[i][j] = 1;
                    else if (end >= j)
                        dp[i][j] = Math.min(dp[i][j], dp[i][start] + 1);
                    else if (start <= i)
                        dp[i][j] = Math.min(dp[i][j], dp[end][j] + 1);
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i][start] + dp[end][j] + 1);
                }
            }
        }
        return dp[0][T] >= INF ? -1 : dp[0][T];
    }
}
