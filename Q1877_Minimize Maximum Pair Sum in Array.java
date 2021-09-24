/**
 * Created by csy99 on 9/23/21.
 */
class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0; 
        int r = n-1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, nums[l]+nums[r]);
            l++;
            r--;
        }
        return res;
    }
}
