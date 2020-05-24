/**
 * Created by csy99 on 5/23/20 during contest. 
 */
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int res = Integer.MIN_VALUE;
        int m = nums1.length;
        int n = nums2.length;
        int[][] prod = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prod[i][j] = nums1[i] * nums2[j];
            }
        }
        int len = Math.min(m, n);
        // first i elements in nums1, first j elements in nums2, used elements: k
        int[][][] dp = new int[m+1][n+1][len+1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= len; k++)
                    dp[i][j][k] = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= Math.min(i,j); k++) {
                    if (i > 1) 
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                    if (j > 1) 
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k]);
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-1][k-1] + prod[i-1][j-1]);
                }
            }
        }
        for (int k = 1; k <= len; k++)
            res = Math.max(res, dp[m][n][k]);
        return res;
    }
}
