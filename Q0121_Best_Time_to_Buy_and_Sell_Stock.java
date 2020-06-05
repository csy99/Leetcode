package Leetcode;

/**
 * Created by csy99 on 2/23/20.
 */
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    // dp, time: O(n), space: O(n)
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int max = 0;
        int[] lowest = new int[prices.length];  // lowest price before today
        lowest[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            lowest[i] = Math.min(lowest[i-1], prices[i-1]);
            if (prices[i] - lowest[i] > max)
                max = prices[i] - lowest[i];
        }
        return max;
    }
    
    // dp, time: O(n), space: O(1)
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int preLow = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > preLow)
                profit = Math.max(profit, prices[i]-preLow);
            else
                preLow = prices[i];
        }
        return profit;
    }
}
