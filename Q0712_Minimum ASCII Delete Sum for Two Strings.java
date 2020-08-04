
/**
 * Created by csy99 on 8/4/20.
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] cost = new int[m+1][n+1];
        for (int i = 1; i <= m; i++)
            cost[i][0] = cost[i-1][0] + s1.charAt(i-1);
        for (int j = 1; j <= n; j++)
            cost[0][j] = cost[0][j-1] + s2.charAt(j-1);
        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = s2.charAt(j-1);
                if (c1 == c2)
                    cost[i][j] = cost[i-1][j-1];
                else
                    cost[i][j] = Math.min(cost[i-1][j] + c1, cost[i][j-1] + c2);
            }
        }
        return cost[m][n];
    }
}
