/**
 * Given a non-empty 2D array grid of 0's and 1's, 
 * an island is a group of 1's (representing land) connected 4-directionally 
 * (horizontal or vertical). 
 * You may assume all four edges of the grid are surrounded by water.

Count the number of distinct islands. 
An island is considered to be the same as another if and only if one island can be translated 
(and not rotated or reflected) to equal the other.

Example 1:

11000
11000
00011
00011
Given the above grid map, return 1.

Example 2:

11011
10000
00001
11011
Given the above grid map, return 3.
 * 
 */
// time: O(mn), space: O(mn)
class Solution {
    int[] dirs = new int[] {-1, 0, 1, 0, -1};
    String[] code = new String[] {"L", "U", "R", "D"};
    int m;
    int n;
    Set<String> seen;
    /**
     * 
     * @param grid
     * @return
     */
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        seen = new HashSet();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                String path = dfs(grid, i, j, "");
                seen.add(path);
            }
        }
        return seen.size();
    }
    
    private String dfs(int[][] grid, int r, int c, String path) {
        // O: out of bounds or water
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 0) 
            return "O";
        grid[r][c] = 0;
        for (int d = 0; d < 4; d++) 
            path += dfs(grid, r+dirs[d], c+dirs[d+1], code[d]);
        return path;
    }
}
