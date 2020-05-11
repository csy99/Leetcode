/**
 * Created by csy99 on 5/8/20. 
 */
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] cnt = new int[n][n];
        for (int i = 0; i < n; i++)
            cnt[i][i] = 1;
        for (int len = 1; len < n; len++) {
            for (int i = 0; i+len < n; i++) {
                int j = i + len;
                if (j > i)  
                    cnt[i][j] = cnt[i][j-1] + 1;  // the worst case (print last char at a new round)
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j))
                        cnt[i][j] = Math.min(cnt[i][j], cnt[i][k] + cnt[k+1][j] - 1);
                }
            }
        }
        return cnt[0][n-1];
    }
}
