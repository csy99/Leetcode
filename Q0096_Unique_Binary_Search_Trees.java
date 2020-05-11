package Leetcode;

/**
 * Created by csy99 on 4/8/20.
 * 
 * 
 */
public class Q096_Unique_Binary_Search_Trees {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        }
        return dp[n];
}
