/**
 * Created by csy99 on 3/14/21.
 */
class Solution {
    // time: O(n)
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int res = nums[k];
        int mini = res;
        int i = k;
        int j = k;
        while (i > 0 || j < n-1) {
            if (i == 0)
                j++;
            else if (j == n-1)
                i--;
            else if (nums[i-1] < nums[j+1])
                j++;
            else
                i--;
            mini = Math.min(mini, Math.min(nums[i],nums[j]));
            res = Math.max(res, mini*(j-i+1));
        }
        return res;
    }
}
