/**
 * Created by csy99 on 7/12/21.
 */
class Solution {
    int m;
    int n;
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public int largestIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int id = 2;
        // label each island with different id
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == 1) 
                    dfs(grid, i, j, id++);
        // calculate area of each island
        int[] area = new int[id];  
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] > 0)
                    area[grid[i][j]]++;
        if (id == 3) {  // only one island
            if (area[2] == m*n)  // no water in the grid
                return m*n;
            return area[2] + 1;
        }
        int res = 0;
        // try connecting island
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == 0) {
                    int cur = 1;
                    Set<Integer> used = new HashSet();
                    for (int d = 0; d < 4; d++) {
                        int r = i+dirs[d], c = j+dirs[d+1];
                        if (r < 0 || c < 0 || r >= m || c >= n || used.contains(grid[r][c]))
                            continue;
                        used.add(grid[r][c]);
                        cur += getArea(grid, r, c, area);
                    }
                    res = Math.max(cur, res);
                }
        return res;
    }
    
    private int getArea(int[][] grid, int r, int c, int[] area) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0)
            return 0;
        int id = grid[r][c];
        return area[id];
    }
    
    private void dfs(int[][] grid, int r, int c, int l) {
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1)
            return;
        grid[r][c] = l;
        for (int d = 0; d < 4; d++) 
            dfs(grid, r+dirs[d], c+dirs[d+1], l);
    }
}
