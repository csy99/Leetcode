package Leetcode;

/**
 * Created by csy99 on 4/18/21.
 */
public class Q518_Coin_Change_2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int c: coins) {
            for (int a = 1; a <= amount; a++) {
                if (c > a) continue;
                dp[a] += dp[a-c];
            }
        }
        return dp[amount];
    }
}
