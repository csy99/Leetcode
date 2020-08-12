/**
 * Created by csy99 on 5/8/20. 
 */
class Solution {
    // greedy
    public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        if (n == 0) return -1;
        Arrays.sort(clips, (c1, c2) -> c1[0] - c2[0]);
        if (clips[0][0] > 0 || clips[n-1][1] < T)
            return -1;
        int end = -1;
        int potential = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (potential >= T || clips[i][0] > potential) 
                break;
            if (clips[i][0] > end) {
                res++;
                end = potential;
            }
            potential = Math.max(potential, clips[i][1]);
        }
        if (potential < T) return -1;
        return res;
    }
    
    // dp
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
