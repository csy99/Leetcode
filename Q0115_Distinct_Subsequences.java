package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q115_Distinct_Subsequences {
    public int numDistinct(String s, String t) {
        int res = 0;
        int m = s.length();
        int n = t.length();
        if (m == 0 || n == 0 || m < n)
            return 0;
        // dp[i][j]: number of subseq of s[1:i] equals t[1:j]
        int[][] cnt = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)  // using chars in s to match "" in t
            cnt[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= Math.min(i,n); j++) {
                cnt[i][j] = cnt[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1))
                    cnt[i][j] += cnt[i-1][j-1];
            }
        }
        return cnt[m][n];
    }
}
