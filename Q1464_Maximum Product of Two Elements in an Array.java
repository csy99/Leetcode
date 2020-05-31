/**
 * Created by csy99 on 5/30/20 during contest.
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                res = Math.max(res, (nums[i]-1)*(nums[j]-1));
            }
        }
        return res;
    }
}
