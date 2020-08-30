/**
 * Created by csy99 on 8/30/20.
 */
// The trick is maximum remove 2 points can get more than two islands.
// There is always one node in the cornor, for example:
// 0 1 1 1 0
// 0 1 1 1 0
// 0 1 1 1 0
// 0 0 0 0 0
// we can always remove the point next to the right-bottom 1 to get more than 2 island, this case we remove [1,3],[2,2]
// 0 1 1 1 0
// 0 1 1 0 0
// 0 1 0 1 0
// 0 0 0 0 0
// So only need remove at most 2
// special case,
// 0 1s, then return 0;
// 1 1s, then return 1;
class Solution {
    int m; 
    int n;
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (num_island(grid) != 1)
            return 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                grid[i][j] = 0;
                if (num_island(grid) != 1)
                    return 1;
                grid[i][j] = 1;
            }
        return 2;
    }
    
    private int num_island(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j] && grid[i][j] == 1) {
                    res++;
                    dfs(visited, grid, i, j);
                }
        return res;
    }
    
    private void dfs(boolean[][] visited, int[][] grid, int y, int x) {
        if (y < 0 || x < 0 || y >= m || x >= n || grid[y][x] == 0)
            return;
        if (visited[y][x])
            return;
        visited[y][x] = true;
        dfs(visited, grid, y-1, x);
        dfs(visited, grid, y+1, x);
        dfs(visited, grid, y, x-1);
        dfs(visited, grid, y, x+1);
    }
}

