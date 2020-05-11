package Leetcode;

/**
 * Created by csy99 on 5/5/20.
 */
public class Q494_Target_Sum {
    // dp
    // time: O(n*sum), space: O(sum)
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) return 0;
        int[] dp = new int[2*1000+1];
        dp[1000] = 1;
        for (int num: nums) {
            int[] cur = new int[2*1000+1];
            for (int i = -1000; i <= 1000; i++) {
                int plusOp = i - num + 1000 > 0 ? dp[i - num + 1000] : 0;
                int minusOp = i + num + 1000 <= 2000 ? dp[i + num + 1000] : 0;
                cur[i + 1000] = plusOp + minusOp;
            }
            dp = cur;
        }
        return dp[1000 + S];
    }
    
    // Convert the problem: partition the array into P set and N set such that sum(P) - sum(N) = S
    // sum(P) + sum(P) = sum(N) + sum(P) + S => sum(P) = (sum + S)/2
    // time: O(n*S), space: O(S), S < sum
    public int findTargetSumWays(int[] nums, int S) {
        S = Math.abs(S);  // the problem is symmetric
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (S > sum || (sum + S) % 2 == 1)  // impossible for such partition to exist
            return 0;
        int target = (sum + S) / 2;
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int num: nums) {
            for (int i = target; i >= num; i--) {
                ways[i] += ways[i - num];
            }
        }
        return ways[target];
    }
}
