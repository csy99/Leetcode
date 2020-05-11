/**
 * Created by csy99 on 4/27/20. 
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        if (m == 0) return 0;
        int n = A[0].length;
        if (n == 0) return 0;
        int[] sum = A[0];
        for (int i = 1; i < m; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0 && j == n-1)
                    cur[j] += A[i][j];
                else if (j == 0)
                    cur[j] = A[i][j] + Math.min(sum[j], sum[j+1]);
                else if (j == n-1)
                    cur[j] = A[i][j] + Math.min(sum[j], sum[j-1]);
                else 
                    cur[j] = A[i][j] + Math.min(sum[j-1], Math.min(sum[j], sum[j+1]));
            }
            sum = cur;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, sum[i]);
        return res;
    }
}
