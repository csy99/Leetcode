package Leetcode;

import java.util.List;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q120_Triangle {
  // ordinary dp, space complexity: O(n^2)
  // difficulty is how you deal with the corner case
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int minCost = Integer.MAX_VALUE;
    int[][] cost = new int[n+1][n+1];
    for (int i = 1; i < n + 1; i++)
      for (int j = 1; j < i+1; j++) {
        cost[i][j] = triangle.get(i-1).get(j-1);
        if (i == 1 && j == 1) continue;
        else if (j == 1) cost[i][j] += cost[i-1][j];
        else if (j == i) cost[i][j] += cost[i-1][j-1];
        else cost[i][j] += Math.min(cost[i-1][j], cost[i-1][j-1]);
      }
    for (int k = 1; k < n + 1; k++) 
      minCost = Math.min(cost[n][k], minCost);
    return minCost;
  }
    
    // rolling array, space complexity: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] cost = new int[n];
        cost[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) { // rows
            int[] cur = new int[n];
            for (int j = 0; j <= i; j++) {
                cur[j] = triangle.get(i).get(j);
                if (j == 0)
                    cur[j] += cost[j];
                else if (j == i)
                    cur[j] += cost[j-1];
                else
                    cur[j] += Math.min(cost[j], cost[j-1]);
            }
            cost = cur;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            res = Math.min(res, cost[j]);
        return res;
    }

  // reuse input, space complexity: O(1)
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (i == 0 && j == 0) continue;
        else if (j == 0) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
        else if (j == i) triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
        else triangle.get(i).set(j, triangle.get(i).get(j) + 
                                 Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1)));
      }
    }
    for (int k = 0; k < n; k++) 
      minCost = Math.min(triangle.get(n-1).get(k), minCost);
    return minCost;
  }
}
