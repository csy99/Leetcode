/**
 * Created by csy99 on 8/26/21.
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur == sum - cur - nums[i])
                return i;
            cur += nums[i];
        }
        return -1;
    }
}
