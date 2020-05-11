/**
 * Created by csy99 on 5/9/20. 
 */
class Solution {
    // convert the problem for two people starting from last cell 
    // and let them go to the first cell
    int[][][] dp;
    int[][] grid;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        dp = new int[n][n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;
        this.grid = grid;
        return Math.max(0, search(n-1, n-1, n-1));
    }
    
    // x1 + y1 = x2 + y2
    public int search(int y1, int x1, int x2) {
        int y2 = y1 + x1 - x2;
        if (y1 < 0 || x1 < 0 || y2 < 0 || x2 < 0)
            return -1;
        if (grid[y1][x1] < 0 || grid[y2][x2] < 0)
            return -1;
        if (x1 == 0 && y1 == 0)
            return grid[y1][x1];
        if (dp[y1][x1][x2] != Integer.MIN_VALUE)
            return dp[y1][x1][x2];
        int res = Math.max(
            Math.max(search(y1, x1-1, x2-1), search(y1-1, x1, x2)), 
            Math.max(search(y1, x1-1, x2), search(y1-1, x1, x2-1))
        );
        if (res < 0) {
            dp[y1][x1][x2] = -1;
            return -1;
        }
        res += grid[y1][x1];
        if (x1 != x2)  // two people not in one cell
            res += grid[y2][x2];
        dp[y1][x1][x2] = res;
        return res;
    }
}
