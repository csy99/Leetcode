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
        if (prices.length <= 1)
            return 0;
        int max = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int lowTillNow = Math.min(lowest, prices[i-1]);
            if (prices[i] - lowTillNow > max)
                max = prices[i] - lowTillNow;
            lowest = lowTillNow;
        }
        return max;
    }
}
