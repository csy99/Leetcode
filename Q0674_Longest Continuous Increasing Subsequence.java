/**
 * Created by csy99 on 1/18/2021.
 */
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int l = -1;
        for (int r = 0; r < n; r++) {
            if (r == 0 || nums[r] > nums[r-1]) {
                res = Math.max(res, r-l);
            } else {
                l = r-1;
            }
        }
        return res;
    }
}
