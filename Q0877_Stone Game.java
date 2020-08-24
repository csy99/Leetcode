/**
 * Created by csy99 on 8/23/20.
 */
class Solution {
    // min-max + memoization
    Integer[][] mem;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        mem = new Integer[n][n];
        return helper(piles, 0, n-1) > 0;
    }
    
    private int helper(int[] piles, int l, int r) {
        if (l > r) return 0;
        if (mem[l][r] != null)
            return mem[l][r];
        int res = Math.max(piles[l] - helper(piles, l+1, r), 
                          piles[r] - helper(piles, l, r-1));
        mem[l][r] = res;
        return res;
    }
    
    // dp, space: O(n)
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i] = max(my score - op score) for piles[i] to piles[i+len-1]
        int[] dp = piles.clone();
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i + len -1;
                dp[i] = Math.max(piles[i] - dp[i+1],
                                piles[j] - dp[i]);
            }
        }
        return dp[0] > 0;
    }
}
