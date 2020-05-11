/**
 * Created by csy99 on 5/4/20. 
 */
 class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m == 0 || n == 0) return 0;
        int[][] len = new int[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i-1] == B[j-1]) {
                    len[i][j] = len[i-1][j-1] + 1;
                    res = Math.max(len[i][j], res);
                }
            }
        }
        return res;
    }
}
