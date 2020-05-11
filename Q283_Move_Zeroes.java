package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class Q283_Move_Zeroes {
  public void moveZeroes(int[] nums) {
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0)
        nums[pos++] = nums[i];
    }
    for (int i = pos; i < nums.length; i++)
      nums[i] = 0;
  }
}
