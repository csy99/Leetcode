package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m+1][n+1];
        int largest = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '0')
                    continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                largest = Math.max(largest, dp[i][j] * dp[i][j]);
            }
        }
        return largest;
    }
}
