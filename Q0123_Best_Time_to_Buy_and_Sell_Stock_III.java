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

    // known bugs: [2,1,2,0,1]
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        // dp[i][j]: max profit sell on day i with j transactions
        int[][] hold = new int[n][2]; 
        int[][] sold = new int[n][2];
        int[][] rest = new int[n][2];
        for (int i = 0; i < n; i++) {
            hold[i][0] = -prices[0];
            hold[i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            rest[i][0] = Math.max(rest[i-1][0], sold[i-1][0]);
            hold[i][0] = Math.max(rest[i-1][0]-prices[i], hold[i-1][0]);
            sold[i][0] = hold[i-1][0] + prices[i];
            if (i > 1) {
                // sold yesterday buy today
                hold[i][1] = Math.max(hold[i][1], sold[i-1][0]-prices[i]); 
                if (i > 2) {
                    hold[i][1] = Math.max(rest[i-1][1]-prices[i], hold[i-1][1]);
                    rest[i][1] = Math.max(rest[i-1][1], sold[i-1][1]);
                    sold[i][1] = hold[i-1][1] + prices[i];
                }
            }
        }
        return Math.max(Math.max(rest[n-1][0], rest[n-1][1]), Math.max(sold[n-1][0], sold[n-1][1]));
    }
