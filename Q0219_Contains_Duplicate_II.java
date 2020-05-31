package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 2/23/2020.
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class Q219_Contains_Duplicate_II {
    // HashMap
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
          return true;
        else
          map.put(nums[i], i);
      }
      return false;
    }
    
    // HashSet
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0 || nums.length < 2) return false;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
          if (!s.add(nums[i]))  // dup val
            return true;
          if (i >= k)
            s.remove(nums[i-k]);
        }
        return false;
   }
    
    // two pointers. 
    // Known bugs for this alg. input: [10, 15, 15, 24], 3
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      if (k <= 0 || nums.length <= 1)
        return false;
      int left = 0;
      int right = 1;
      while (right < nums.length) {
        if (left != right && nums[left] == nums[right])
          return true;
        if (right - left < k)
          right++;
        else
          left++;
      }
      right--;  // now right is last element in the array
      while (left < right) {
        if (nums[left] == nums[right])
          return true;
        left++;
      }
      return false;
    }
}
