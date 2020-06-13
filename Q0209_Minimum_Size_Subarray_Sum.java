package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int l = 0;
        int r = 0;
        int len = n+1;
        int sum = 0;
        while (r < n) {
            if (nums[r] >= s)
                return 1;
            sum += nums[r];
            while (sum >= s) {
                len = Math.min(len, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if (len == n+1) return 0;
        return len;
    }
}
