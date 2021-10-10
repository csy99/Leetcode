/**
 * Created by csy99 on 10/9/21.
 */
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int j = 0; j < n; j++)
            dp[j] = points[0][j];
        for (int i = 1; i < m; i++) {
            long[] cur = new long[n];
            long[] leftLargest = new long[n];
            long[] rightLargest = new long[n];
            leftLargest[0] = dp[0];
            rightLargest[n-1] = dp[n-1];
            for (int j = 1; j < n; j++)
                leftLargest[j] = Math.max(leftLargest[j-1]-1, dp[j]);
            for (int j = n-2; j >= 0; j--)
                rightLargest[j] = Math.max(rightLargest[j+1]-1, dp[j]);
            for (int j = 0; j < n; j++)
                cur[j] = points[i][j] + Math.max(leftLargest[j], rightLargest[j]);
            dp = cur;
        }
        long res = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++)
            res = Math.max(dp[j], res);
        return res;
    }
}
