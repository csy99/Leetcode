package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */

public class Q265_Paint_House_II {
  public int minCostII(int[][] costs) {
    if (costs.length < 1) return 0;
    int m = costs.length;
    int n = costs[0].length;
    int[][] total = new int[m][n];
    for (int j = 0; j < n; j++)
      total[0][j] = costs[0][j];
    for (int i = 1; i < m; i++) {
      for (int j = 0; j < n; j++) {
        total[i][j] = Integer.MAX_VALUE;
        for (int last = 0; last < n; last++) {
          if (j == last) continue;
          total[i][j] = Math.min(total[i][j], total[i-1][last] + costs[i][j]);
        }
      }
    }
    
    // find the min costs
    int minCost = total[m-1][0];
    for (int c: total[m-1])
      minCost = Math.min(minCost, c);
    return minCost;
  }
}
