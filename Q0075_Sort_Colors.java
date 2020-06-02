package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 * 荷兰国旗问题
 * https://leetcode.com/problems/sort-colors/
 */
public class Q075_Sort_Colors {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = -1;  // 0 area
        int r = nums.length;  // 2 area
        while (i < r) {
            if (nums[i] == 0) {
                int tmp = nums[l+1];
                nums[l+1] = nums[i];
                nums[i] = tmp;
                i++;
                l++;
            } else if (nums[i] == 2) {
                // the number being swapped need to be checked again
                int tmp = nums[r-1];
                nums[r-1] = nums[i];
                nums[i] = tmp;
                r--;
            } else
                i++;
        }
    }
}
