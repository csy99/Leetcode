package Leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * Created by csy99 on 2/23/20.
 */
public class Q045_Jump_Game_II {
    public int jump(int[] nums) {
      if (nums.length < 2)
        return 0;
      int curMax = 0;
      int nextMax = 0;
      int step = 0;
      int index = 0;
      while (index <= curMax) {  // can deal with cases where last index not reachable
        while (index <= curMax) {
          nextMax = Math.max(nextMax, index + nums[index]);
          index ++;
        }
        curMax = nextMax;
        step++;
        if (curMax >= nums.length - 1)
          return step;
      }
      return 0;
    }
}
