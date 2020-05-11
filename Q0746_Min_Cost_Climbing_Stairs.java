/**
 * Created by csy99 0n 4/25/20. 
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1)
            return 0;
        int[] dp0 = new int[cost.length+1];
        dp0[1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            dp0[i] = cost[i-1] + Math.min(dp0[i-2], dp0[i-1]);
        }
        return Math.min(dp0[cost.length], dp0[cost.length-1]);
    }
}
