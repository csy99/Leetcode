package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 * 
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Q064_Minimum_Path_Sum {
  public int minPathSum(int[][] grid) {
    if (grid.length == 0) return 0;
    int m = grid.length;
    int n = grid[0].length;
    int[] cost = new int[n];
    cost[0] = grid[0][0];
    for (int j = 1; j < n; j++) 
      cost[j] = cost[j-1] + grid[0][j];
    
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (j == 0) 
          cost[0] = grid[i][0] + cost[0];
        else
          cost[j] = grid[i][j] + Math.min(cost[j-1], cost[j]);
      }
    }
    return cost[n-1];
  }
}
