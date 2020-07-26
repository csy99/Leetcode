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
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return 0;
        
        int[] res = new int[k];
        for (int i = 0; i < n; i++) {
            int[] cur = new int[k];
            for (int j = 0; j < k; j++)
                cur[j] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) 
                for (int p = 0; p < k; p++) {
                    if (j == p) continue;
                    cur[j] = Math.min(cur[j], costs[i][j] + res[p]);
                }
            res = cur;
        }
        int best = res[0];
        for (int r: res)
            best = Math.min(best, r);
        return best;
    }
}
