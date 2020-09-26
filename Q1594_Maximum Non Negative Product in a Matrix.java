/**
 * Created by csy99 on 9/26/20.
 */
class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 0 || grid[m-1][n-1] == 0) return 0;
        int kmod = (int)1e9 + 7;
        long[][] maxs = new long[m][n];
        long[][] mins = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maxs[0][0] = grid[0][0];
                    mins[0][0] = grid[0][0];
                } else if (i == 0) {
                    maxs[0][j] = maxs[0][j-1] * grid[0][j];
                    mins[0][j] = mins[0][j-1] * grid[0][j];
                } else if (j == 0) {
                    maxs[i][0] = maxs[i-1][0] * grid[i][0];
                    mins[i][0] = mins[i-1][0] * grid[i][0];
                } else {
                    maxs[i][j] = Math.max(
                        Math.max(maxs[i-1][j] * grid[i][j], maxs[i][j-1] * grid[i][j]),
                        Math.max(mins[i-1][j] * grid[i][j], mins[i][j-1] * grid[i][j])
                    );
                    mins[i][j] = Math.min(
                        Math.min(maxs[i-1][j] * grid[i][j], maxs[i][j-1] * grid[i][j]),
                        Math.min(mins[i-1][j] * grid[i][j], mins[i][j-1] * grid[i][j])
                    );
                }
            }
        }
        if (maxs[m-1][n-1] < 0)
            return -1;
        return (int) (maxs[m-1][n-1] % kmod);
    }
}
