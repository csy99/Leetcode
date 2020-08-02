package Leetcode;

/**
 * Created by csy99 on 3/23/20.
 * <p>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Q010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;  // "" matches ""
        for (int i = 1; i <= m; i++)
            if (p.charAt(i-1) == '*')
                match[i][0] = match[i-2][0];
        for (int i = 1; i <= m; i++) {
            char pc = p.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(j-1);
                if (pc == '.' || pc == sc)
                    match[i][j] = match[i-1][j-1];
                else if (pc == '*') {  // assume at least one char before "*"
                    // "*" combo match to nothing
                    match[i][j] = match[i-2][j];
                    char p_prev = p.charAt(i-2);
                    // "*" combo match to one or more char in s
                    if (p_prev == '.' || p_prev == sc) 
                        match[i][j] |= match[i][j-1];
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
