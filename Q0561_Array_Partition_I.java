package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 4/7/21.
 */
public class Q561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i+=2)
            res += nums[i];
        return res;
    }
}
