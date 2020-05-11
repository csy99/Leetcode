package Leetcode;

/**
 * Created by csy99 on 3/25/20.
 */
public class Q377_Combination_Sum_IV {
  // recursion
  int[] ways;
  public int combinationSum4(int[] nums, int target) {
    if (nums.length == 0 || target == 0) return 0;
    ways = new int[target+1];
    for (int i = 1; i < ways.length; i++)
      ways[i] = -1;
    ways[0] = 1;
    return helper(nums, target);
  }
  
  private int helper(int[] nums, int target) {
    if (target < 0) 
      return 0;
    if (ways[target] != -1)
      return ways[target];
    int res = 0;
    for (int i = 0; i < nums.length; i++)
      res += helper(nums, target-nums[i]);
    ways[target] = res;
    return ways[target];
  }
    
   // dp
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (num > target || i - num < 0)
                    break;
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
