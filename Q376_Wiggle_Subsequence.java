package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q376_Wiggle_Subsequence {
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int up = 1;  // the last trend for the wiggle sequence is going up
    int down = 1;  // the last trend for the wiggle sequence is going down
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1])
        up = down + 1;
      else if (nums[i] < nums[i - 1])
        down = up + 1;
    }
    return Math.max(up, down);
  }
}
