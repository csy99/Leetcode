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
  
  
    // bucket sort
    long width;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> map = new HashMap();
        width = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i]);
            if (map.containsKey(id))
                return true;
            if (map.containsKey(id-1) && nums[i]-map.get(id-1)<width)
                return true;
            if (map.containsKey(id+1) && map.get(id+1)-nums[i]<width)
                return true;
            map.put(id, (long)nums[i]);
            if (i >= k)
                map.remove(getId(nums[i-k]));
        }
        return false;
    }
    
    private long getId(long i) {
        return i < 0 ? (i+1)/width-1 : i/width;
    }
}
