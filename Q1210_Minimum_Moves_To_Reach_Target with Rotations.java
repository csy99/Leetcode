class Solution {
    public int minimumMoves(int[][] grid) {
        int kinf = 10000;
        int n = grid.length;
        // dp[i][j][0]: tail position at (i, j) facing right
        // dp[i][j][1]: facing downside
        int[][][] dp = new int[n+1][n+1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = kinf;
                dp[i][j][1] = kinf;
            }
        }
        dp[0][1][0] = -1;
        dp[1][0][0] = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean h = false;
                boolean v = false;
                // facing right, try moving right or down
                if (grid[i-1][j-1] == 0 && j < n && grid[i-1][j] == 0) {
                    h = true;
                    dp[i][j][0] = 1 + Math.min(dp[i-1][j][0], dp[i][j-1][0]);
                }
                // facing downside, try moving right or down
                if (grid[i-1][j-1] == 0 && i < n && grid[i][j-1] == 0) {
                    v = true;
                    dp[i][j][1] = 1 + Math.min(dp[i-1][j][1], dp[i][j-1][1]);
                }
                // try clockwise rotation
                if (v && j < n && grid[i][j] == 0) {
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j][0] + 1);
                }
                // try counter clockwise rotation 
                if (h && i < n && grid[i][j] == 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i][j][1] + 1);
                }

            }
        }
        return dp[n][n-1][0] >= kinf ? -1 : dp[n][n-1][0];
    }
}
