package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q334_Increasing_Triplet_Subsequence {
  // Greedy  
  public boolean increasingTriplet(int[] nums) {
      if (nums == null || nums.length <= 2)
        return false;
      int min1 = Integer.MAX_VALUE;
      int min2 = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > min2)  // we find the subseq
          return true; 
        else if (nums[i] < min1)
          min1 = nums[i];
        else if (nums[i] > min1 && nums[i] < min2)
          min2 = nums[i];
      }
      return false;
  }
}
