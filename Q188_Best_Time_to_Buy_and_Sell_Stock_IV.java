/**
 * Created by csy99 on 2/24/20.
 */
public class Q188_Best_Time_to_Buy_and_Sell_Stock_IV {
  // time: O(nk), space: O(min(n, k))
  public int maxProfit(int k, int[] prices) {
    int len = prices.length;
    final int MAX_TRANS = Math.min(k, len/2);  // possible numbers of transactions
    int[] hold = new int[MAX_TRANS+1];  // max profit earned for holding i-th stock
    int[] sell = new int[MAX_TRANS+1];  // max profit earned after selling i-th stock
    for (int trans = 0; trans <= MAX_TRANS; trans++) {
      hold[trans] = Integer.MIN_VALUE;
      // sell[trans] = Integer.MIN_VALUE;  // adding this will result in overflow
    }
    for (int day = 0; day < len; day++) {
      for (int trans = 1; trans <= MAX_TRANS; trans++) {
        hold[trans] = Math.max(hold[trans], sell[trans - 1] - prices[day]);
        sell[trans] = Math.max(sell[trans], hold[trans] + prices[day]);
      }
    }
    return sell[MAX_TRANS];
  }
}
