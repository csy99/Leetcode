package Leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Created by csy99 on 2/23/20.
 */
public class Q220_Contains_Duplicate_III {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet();
    for (int i = 0 ; i < nums.length; i++) {
      Long low = set.floor((long) nums[i]);
      if (low != null && nums[i] - low <= t)
        return true;
      Long high = set.ceiling((long) nums[i]);
      if (high != null && high - nums[i] <= t)
        return true;
      set.add((long) nums[i]);
      if (i >= k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }
}
