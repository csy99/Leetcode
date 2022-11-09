/**
 * Created by csy99 on 11/8/22.
 */
// time: O(n), space: O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int pos = 0;
        boolean copy_last = true;
        for (int i = 0; i < n-1; i++) {
            if (nums[i] == 0) continue;
            if (nums[i] == nums[i+1]) {
                nums[pos] = nums[i] * 2;
                pos++;
                i++;
                if (i+1 == n)
                    copy_last = false;
            } else {
                nums[pos++] = nums[i];
            }
        }
        if (copy_last && nums[n-1] != 0) 
            nums[pos++] = nums[n-1];
        for (int i = pos; i < n; i++)
            nums[i] = 0;
        return nums;
    }
}
