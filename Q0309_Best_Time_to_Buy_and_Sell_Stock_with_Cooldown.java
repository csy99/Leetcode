
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
        int[] rest = new int[n];
        int[] hold = new int[n];
        int[] sold = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            rest[i] = Math.max(rest[i-1], sold[i-1]);
            hold[i] = Math.max(hold[i-1], rest[i-1] - prices[i]);
            sold[i] = prices[i]+hold[i-1];
        }
        return Math.max(rest[n-1], sold[n-1]);
    }
}
