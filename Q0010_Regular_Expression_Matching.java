package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 * <p>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Q010_Regular_Expression_Matching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;
    int m = s.length();
    int n = p.length();
    boolean[][] match = new boolean[m+1][n+1];
    match[0][0] = true;  // "" matches ""
    for (int j = 1; j <= n; j++) {
      // assume p won't start with *
      if (p.charAt(j-1) == '*')
        match[0][j] = match[0][j-2];
    }
    
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char sc = s.charAt(i-1);
        char pc = p.charAt(j-1);
        if (pc == '.' || sc == pc)
          match[i][j] = match[i-1][j-1];
        else if (pc == '*') {
          char p_prev = p.charAt(j-2);
          if (p_prev == '.' || p_prev == sc)
            match[i][j] = match[i-1][j] || match[i][j-2];
          else
            match[i][j] = match[i][j-2];
        } 
      }
    }
    return match[m][n];
  }

    public static void main(String[] args) {
        Q010_Regular_Expression_Matching sol = new Q010_Regular_Expression_Matching();
        String pattern = "ab*a*c*a";
        String str = "aaa";
        boolean isMatch = sol.isMatch(str, pattern);
    }
}
