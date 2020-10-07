/**
 * Created by csy99 on 10/7/20.
 */
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int n = s.length();
        boolean[][] isPa = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i + len - 1;
                char first = s.charAt(i);
                char second = s.charAt(j);
                if (first == second) {
                    if (len <= 2 || (len > 2 && isPa[i+1][j-1])) {
                        res++;
                        isPa[i][j] = true;  
                    }
                } 
            }
        }
        return res;
    }
}
