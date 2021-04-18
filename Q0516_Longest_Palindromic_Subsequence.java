package Leetcode;

/**
 * Created by csy99 on 4/17/21.
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) 
            dp[i][i] = 1;
        char[] arr = s.toCharArray();
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n-len+1; i++) {
                int j = i+len-1;
                if (len == 2 && arr[i-1] == arr[j-1])
                    dp[i][j] = 2;
                else if (arr[i-1] == arr[j-1])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[1][n];
    }
}
