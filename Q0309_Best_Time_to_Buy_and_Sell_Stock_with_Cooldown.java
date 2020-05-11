
/**
 * Created by csy99 on 2/24/20.
 */
public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int hold = Integer.MIN_VALUE;
        int sell = 0;
        int rest = 0;
        for (int p: prices) {
            int prev_sold = sell;
            sell = hold + p;
            hold = Math.max(hold, rest - p);
            rest = Math.max(rest, prev_sold);
        }
        return Math.max(rest, sell);
    }
  
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        // dp[i]: 0, rest; 1, hold stocks; 2, sell
        int[][] dp = new int[n+1][3];
        for (int i = 0; i <= n; i++)
            dp[i][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i-1]);
            dp[i][2] = dp[i-1][1] + prices[i-1];
        }
        return Math.max(dp[n][0], dp[n][2]);
    }
}
