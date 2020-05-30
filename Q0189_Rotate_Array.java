package Leetcode;

/**
 * Created by csy99 on 5/30/20.
 * <p>
 * https://leetcode.com/problems/rotate-array/
 */
public class Q189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;
        rev(nums, 0, n-1);
        rev(nums, 0, k-1);
        rev(nums, k, n-1);
    }
    
    private void rev(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
