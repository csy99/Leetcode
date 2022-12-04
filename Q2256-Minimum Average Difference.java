/**
 * Created by csy99 on 12/4/22.
 */
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int num: nums)
            sum += num;
        long front_sum = 0;
        int front = 0;
        int min_diff = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            front_sum += nums[i];
            front++;
            int front_avg = (int)(front_sum / front);
            int back_avg = i == n - 1 ? 0 : (int)((sum - front_sum) / (n - front));
            int abs_diff = Math.abs(front_avg - back_avg);
            if (abs_diff < min_diff) {
                min_diff = abs_diff;
                res = i;
            }
        }
        return res;
    }
}
