/**
 * Created by csy99 on 7/12/21.
 */
class Solution {
    int m;
    int n;
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1)
            return 0;
        grid[r][c] = 0;
        int cnt = 0;
        for (int d = 0; d < 4; d++) 
            cnt += dfs(grid, r+dirs[d], c+dirs[d+1]);
        return cnt+1;
    }
}
