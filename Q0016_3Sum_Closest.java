package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 2; i++) {  // the last two elements not need to check 
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int diff = nums[i] + nums[l] + nums[r] - target;
                if (diff == 0)
                    return target;
                if (Math.abs(diff) < Math.abs(delta))
                    delta = diff;
                if (diff < 0)
                    l++;
                else
                    r--;
            }
        }
        return delta+target;
    }
}
