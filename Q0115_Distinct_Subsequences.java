package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q115_Distinct_Subsequences {
  // dp[i][j]: number of subseq of s[1:j] equals t[1:i]
  public int numDistinct(String s, String t) {
    int m = t.length();
    int n = s.length();
    int[][] ways = new int[m+1][n+1];
    for (int j = 0; j < n+1; j++)
      ways[0][j] = 1;
    
    for (int i = 1; i < m+1; i++) {
      for (int j = 1; j < n+1; j++) {
        if (t.charAt(i-1) == s.charAt(j-1))
          ways[i][j] = ways[i-1][j-1] + ways[i][j-1];  // latter term: do not use s[j] to match t[i]
        else
          ways[i][j] = ways[i][j-1];
      }
    }
    return ways[m][n];
  }
}
