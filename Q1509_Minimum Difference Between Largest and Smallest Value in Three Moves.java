/**
 * Created by csy99 on 10/1/21.
 */
class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int diff = nums[i+n-4] - nums[i];
            if (diff < res)
                res = diff;
        }
        return res;
    }
}
