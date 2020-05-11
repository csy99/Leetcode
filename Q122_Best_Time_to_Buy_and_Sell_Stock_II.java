package Leetcode;

/**
 * Created by csy99 on 2/23/20.
 */
public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
      if (prices == null || prices.length < 2)
        return 0;
      int profit = 0;
      for (int i = 0; i < prices.length - 1; i++) {
        if (prices[i + 1] > prices[i])
          profit += prices[i + 1] - prices[i];
      }
      return profit;
    }
}
