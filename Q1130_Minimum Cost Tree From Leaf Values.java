/**
 * Created by csy 99 on 5/9/20. 
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] largest = new int[n][n];
        for (int i = 0; i < n; i++) {
            largest[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) 
                largest[i][j] = Math.max(largest[i][j-1], arr[j]);
        }
        // min sum using arr[i~j]
        int[][] dp = new int[n][n];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i+len < n; i++) {
                int j = i+len;
                dp[i][j] = Integer.MAX_VALUE; 
                for (int k = i; k < j; k++) 
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + largest[i][k]*largest[k+1][j]);
            }
        }
        return dp[0][n-1];
    }
}
