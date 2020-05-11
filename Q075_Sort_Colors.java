package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 * 荷兰国旗问题
 * https://leetcode.com/problems/sort-colors/
 */
public class Q075_Sort_Colors {
  public void sortColors(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    for (int i = 0; i < nums.length && i <= r; i++) {
      if (nums[i] == 0) {
        int tmp = nums[l];
        nums[l++] = nums[i];
        nums[i] = tmp;
      } else if (nums[i] == 2) {
        int tmp = nums[r];
        nums[r--] = nums[i];
        nums[i--] = tmp;  // the number being swapped need to be checked again
      }
    }
  }
}
