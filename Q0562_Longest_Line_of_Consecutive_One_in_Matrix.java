package Leetcode;

public class Q562_Longest_Line_of_Consecutive_One_in_Matrix {
    public getLongestOnes(int[][] mat) {
        int res = 0, m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m][n][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) continue;
                for (int k = 0; k < 4; ++k) 
                    dp[i][j][k] = 1;
                if (j > 0) dp[i][j][0] += dp[i][j - 1][0]; // horizonal
                if (i > 0) dp[i][j][1] += dp[i - 1][j][1]; // vertical
                if (i > 0 && j > 0) dp[i][j][3] += dp[i - 1][j - 1][2]; // diagonal
                if (i > 0 && j < n - 1) dp[i][j][2] += dp[i - 1][j + 1][3]; // anti-diagonal
                for (int k = 0; k < 4; ++k) 
                    res = max(res, dp[i][j][k]);
            }
        }
        return res;
    }
}
