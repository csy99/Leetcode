package Leetcode;

/**
 * Created by csy99 on 2/23/20.
 */
public class Q123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 2)
        return 0;
      // the buying rate for 2 transactions
      int buy1 = Integer.MAX_VALUE;
      int buy2 = Integer.MAX_VALUE;
      // the profits we gained after 2 transactions
      int profit1 = 0;
      int profit2 = 0;
      for (int p: prices) {
        buy1 = Math.min(buy1, p);
        profit1 = Math.max(profit1, p - buy1);
        // the true cost for the second transaction is the buying rate for the second transaction minus the profit we made in the first transaction. 
        buy2 = Math.min(buy2, p - profit1); 
        profit2 = Math.max(profit2, p - buy2);
      }
      return profit2;
    }
}
    // Created by csy99 on 6/5/20.
    // split the array into two parts, sum up the total profits
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        int lowest = prices[0];
        for (int i = 1; i < n; i++) {
            p1[i] = Math.max(prices[i]-lowest, p1[i-1]);
            lowest = Math.min(lowest, prices[i]);
        }
        int highest = prices[n-1];
        for (int i = n-2; i >= 0; i--) {
            p2[i] = Math.max(highest-prices[i], p2[i+1]);
            highest = Math.max(highest, prices[i]);
        }
        int profit = 0;
        // it seems that in this case buying stocks and selling stocks can be completed in one day
        // the reason is valid: think of cancelling the operation on that day
        // otherwise, the final answer will not be able to represent the max profit achieved through only one transaction. 
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, p1[i]+p2[i]);
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        // dp[i][j]: in i-th day using j transaction
        int K = 2;
        int[][] hold = new int[n][K+1];
        int[][] notHold = new int[n][K+1];
        for (int j = 0; j <= K; j++)
            hold[0][j] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= K; j++) {
                notHold[i][j] = Math.max(notHold[i-1][j], hold[i-1][j]+prices[i]);
                hold[i][j] = Math.max(hold[i-1][j], notHold[i-1][j-1]-prices[i]);
            }
        }
        int res = 0;
        for (int j = 0; j <= K; j++)
            res = Math.max(res, notHold[n-1][j]);
        return res;
    }
