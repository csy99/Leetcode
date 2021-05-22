package Leetcode;

/**
 * Created by csy99 on 5/22/21.
 */
public class Q474_Ones_and_Zeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int best = 0;
        int[][] dp = new int[m+1][n+1];
        for (String str: strs) {
            int[] res = counting(str);
            int a = res[0];
            int b = res[1];
            int[][] cur = new int[m+1][n+1];
            // deep copy for 2d-array
            for(int i = 0; i <= m; i++)
                cur[i] = dp[i].clone();
            for (int i = 0; i <= m-a; i++) {
                for (int j = 0; j <= n-b; j++) {
                    cur[i+a][j+b] = Math.max(dp[i+a][j+b], dp[i][j]+1);
                    best = Math.max(best, cur[i+a][j+b]);
                }
            }
            dp = cur;
        }
        return best;
    }
    
    private int[] counting(String str) {
        int[] res = new int[2];
        for (char c: str.toCharArray()) {
            if (c == '0')
                res[0]++;
            else
                res[1]++;
        }
        return res;
    }
}
