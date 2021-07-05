/**
 * Created by csy99 on 7/5/21.
 */
class Solution {
    int m;
    int n;
    int[][] grid;
    Short[][][] mem;
    int[] dirs = new int[] {-1,0,1,0,-1};
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        // third dimension is state (visited or not)
        mem = new Short[m][n][1 << m * n];
        // start point
        int sy = 0;
        int sx = 0;
        int state = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2)
                    state |= getKey(i, j);
                else if (grid[i][j] == 1) {
                    sy = i;
                    sx = j;
                }
            }
        return dfs(sy, sx, state);
    }
    
    private int getKey(int i, int j) {
        return 1 << (i * n + j);
    }
    
    private short dfs(int r, int c, int state) {
        if (mem[r][c][state] != null)
            return mem[r][c][state];
        if (grid[r][c] == 2) {
            if (state == 0) return 1;
            else return 0;
        }
        short path = 0;
        for (int d = 0;d < 4; d++) {
            int nr = r + dirs[d];
            int nc = c + dirs[d+1];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == -1)
                continue;
            int key = getKey(nr, nc);
            // cannot visit a node twice
            if ((state & key) == 0) continue;
            path += dfs(nr, nc, state ^ key);
        }
        return mem[r][c][state] = path;
    }
}
