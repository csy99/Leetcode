package Leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.

 * Created by csy99 on 2/23/19.
 * <p>
 * https://leetcode.com/problems/jump-game/
 */
public class Q055_Jump_Game {
  public boolean canJump(int[] nums) {
      if (nums.length < 2)
        return true;
      int reach = 0;
      for (int i = 0; i < nums.length && i <= reach; i++) {
        reach = Math.max(reach, nums[i] + i);
        
        if (reach >= nums.length - 1)
          return true;
      }
      return false;
  }
}
