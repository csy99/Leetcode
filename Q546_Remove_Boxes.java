package Leetcode;

/**
 * Created by csy99 on 5/9/20.
 */
public class Q546_Remove_Boxes {
    int[][][] dp;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return dfs(boxes, 0, n-1, 0);
    }
    
    public int dfs(int[] boxes, int l, int r, int k) {
        if (l > r) 
            return 0;
        if (dp[l][r][k] > 0)
            return dp[l][r][k];
        dp[l][r][k] = dfs(boxes, l, r-1, 0) + (k+1)*(k+1);
        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r])
                dp[l][r][k] = Math.max(dp[l][r][k], 
                                dfs(boxes, l, i, k+1) + dfs(boxes, i+1, r-1, 0));
        }
        return dp[l][r][k];
    }
}
