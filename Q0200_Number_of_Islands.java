package Leetcode;

/**
 * Created by csy99 on 3/28/20.
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * <p>
 * Example 2:
 * <p>
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class Q200_Number_of_Islands {
  int m;
  int n;
  public int numIslands(char[][] grid) {
    m = grid.length;
    if (m == 0) return 0;
    n = grid[0].length;
    
    int res = 0;
    for (int y = 0; y < m; y++)
      for (int x = 0; x < n; x++) {
        if (grid[y][x] == '1') {
          res++;
          dfs(grid, y, x);
        }
      }
    return res;
  }
  
  private void dfs(char[][] grid, int y, int x) {
    if (y < 0 || x < 0 || y >= m || x >= n || grid[y][x] == '0')
      return;
    grid[y][x] = '0';
    dfs(grid, y+1, x);
    dfs(grid, y-1, x);
    dfs(grid, y, x+1);
    dfs(grid, y, x-1);
  }
}
