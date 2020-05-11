package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 */
public class Q044_Wildcard_Matching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;
    int m = s.length();
    int n = p.length();
    boolean[][] match = new boolean[m+1][n+1];
    match[0][0] = true;
    for (int j = 1; j <= n; j++) {
      if (p.charAt(j-1) == '*')
        match[0][j] = match[0][j-1];
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char sc = s.charAt(i-1);
        char pc = p.charAt(j-1);
        if (pc == '?' || pc == sc)
          match[i][j] = match[i-1][j-1];
        else if (pc == '*') 
          match[i][j] = match[i-1][j] || match[i][j-1];
      }
    }
    return match[m][n];
  }
}
