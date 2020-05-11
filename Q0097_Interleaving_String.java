package Leetcode;

/**
 * Created by csy99 on 3/22/20.
 */
public class Q097_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        // match[i][j] checks if s1[0~i] and s2[0~j] can be used to produce s3[0~(i+j)]
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) continue;
                char c3 = s3.charAt(i+j-1);
                if (i > 0 && s1.charAt(i-1) == c3) 
                    match[i][j] |= match[i-1][j];
                if (j > 0 && s2.charAt(j-1) == c3)
                    match[i][j] |= match[i][j-1];
            }
        }
        return match[m][n];
    }
}
