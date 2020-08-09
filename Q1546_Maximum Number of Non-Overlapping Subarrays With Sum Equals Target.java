/**
 * Created by csy99 on 8/8/20 during contest.
 */
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] sums = new int[n+1];
        for (int i = 1; i <= n; i++)
            sums[i] = sums[i-1] + nums[i-1];
        int res = 0;
        int p = 0;
        for (int r = 1; r <= n; r++) {
            for (int l = p; l < r; l++) {
                if (sums[r] - sums[l] == target) {
                    p = r;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
