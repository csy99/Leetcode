/**
 * Created by csy99 on 8/12/20.
 */
// min-max
class Solution {
    int n;
    int[] sumRight;
    int[][] dp;
    int[] piles;
    public int stoneGameII(int[] piles) {
        this.piles = piles;
        n = piles.length;
        dp = new int[n][n+1];
        sumRight = new int[n+1];
        for (int i = n-1; i >= 0; i--)
            sumRight[i] = sumRight[i+1] + piles[i];
        int relativeScore = helper(0, 1);
        return (sumRight[0] + relativeScore) / 2;
    }
    
    private int helper(int s, int m) {
        if (s >= n) return 0;
        m = Math.min(m, n);
        if (dp[s][m] > 0) return dp[s][m];
        if (s + 2*m >= n) {
            dp[s][m] = sumRight[s];
            return sumRight[s];
        }
        int best = Integer.MIN_VALUE;
        int cur = 0;
        for (int x = 1; x <= 2*m; x++) {
            cur += piles[s+x-1];
            int m2 = Math.max(x, m);
            best = Math.max(best, cur - helper(s+x, m2));
        }
        dp[s][m] = best;
        return best;
    }
}

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sums = new int[n];
        sums[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--)
            sums[i] = sums[i+1] + piles[i];
        // dp[i][j]: starting from pile i, with limit (M) = j
        int[][] dp = new int[n][n];  
        for (int i = n-1; i >= 0; i--) {
            for (int m = 1; m <= n/2 + 1; m++) {
                for (int x = 1; x <= 2*m && i+x <= n; x++) {
                    if (i + x == n)  // can get all the remaining piles
                        dp[i][m] = Math.max(dp[i][m], sums[i]);
                    else 
                        dp[i][m] = Math.max(dp[i][m], sums[i] - dp[i+x][Math.max(m, x)]);
                }
            }
        }
        return dp[0][1];
    }
}
