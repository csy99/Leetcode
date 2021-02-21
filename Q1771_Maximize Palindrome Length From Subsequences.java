/**
 * Created by csy99 on 2/21/21.
 */
class Solution {
    public int longestPalindrome(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int res = 0;
        int[][] dp = helper(word1+word2);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] != arr2[j]) continue;
                res = Math.max(res, 2+dp[i+1][m+j-1]);
            }
        }
        return res;
    }
    
    private int[][] helper(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i+len <= n; i++) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}
