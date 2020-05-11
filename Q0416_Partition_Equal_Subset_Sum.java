package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 5/4/20.
 */
public class Q416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 == 1) return false;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean[] cur = dp.clone();
            for (int j = 0; j <= sum; j++) {
                if (dp[j])
                    cur[j + num] = true;
            }
            if (cur[sum/2])
                return true;
            dp = cur;
        }
        return false;
    }
}
