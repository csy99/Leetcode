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
