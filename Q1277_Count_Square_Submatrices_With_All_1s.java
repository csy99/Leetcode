/**
 * Created by csy99 on 4/30/20.
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int cnt = 0;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == 0) continue;
                dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                cnt += dp[i][j];
            }
        }
        return cnt;
    }
}
