package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q085_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        // dp[i][j] := max len of all 1s ends with col j at row i.
        int[][] dp = new int[m+1][n+1];
        int largest = 0;
        // get max len for every row
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '0')
                    continue;
                dp[i][j] = dp[i][j-1] + 1;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int len = Integer.MAX_VALUE;
                for (int k = i; k >= 1; k--) {
                    len = Math.min(len, dp[k][j]);
                    if (len == 0) break;
                    int area = len * (i - k + 1);
                    largest = Math.max(largest, area);
                }
            }
        }
        return largest;
    }
}
