/**
 * Created by csy99 on 8/31/21.
 */
public class Solution {
    public int maxProfit(int[] nums, int cutCost, int price) {
        int longest = 0;
        int res = 0;
        for (int num: nums)
            longest = Math.max(longest, num);
        for (int len = 1; len <= longest; len++)
            res = Math.max(res, profit(nums, cutCost, price, len));
        return res;
    }
    
    private int profit(int[] nums, int cut, int price, int len) {
        int sum = 0;
        for (int num: nums) {
            int quotient = num / len;
            int residue = num % len;
            int rev = quotient * price;
            quotient += residue == 0 ? -1 : 0;
            int cost = quotient * cut;
            if (rev > cost)
                sum += rev - cost;
        }
        return sum;
    }
}
