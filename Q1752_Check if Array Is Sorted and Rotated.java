/**
 * Created by csy99 on 2/6/2021 during contest. 
 */
 class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n < 3) return true;
        int cut = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                cut = i;
                break;
            }
        }
        int prev = nums[cut];
        for (int i = cut+1; i < n; i++) {
            if (nums[i] < prev) return false;
            prev = nums[i];
        }
        for (int i = 0; i < cut; i++) {
            if (nums[i] < prev) return false;
            prev = nums[i];
        }
        return true;
    }
}
