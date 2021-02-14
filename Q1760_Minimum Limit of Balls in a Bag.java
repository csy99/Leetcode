/**
 * Created by csy99 on 2/14/21.
 */
class Solution {
    public int minimumSize(int[] nums, int T) {
        int n = nums.length;
        int lo = 1;
        int hi = (int)1e9;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int cnt = 0;
            for (int num: nums)
                cnt += (num-1)/mid;
            if (cnt > T)
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }
}
