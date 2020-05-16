package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p>
 * Would this affect the run-time complexity? How and why?
 */
public class Q081_Search_in_Rotated_Sorted_Array_II {
  // time: avg case: O(log n), worst case: O(n)
  public boolean search(int[] nums, int target) {
    if (nums.length == 0)
      return false;
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int mid = l + (r-l)/2;
      if (nums[mid] == target)
        return true;
      if (nums[l] == nums[r])  // no enough info!!!
        l++;
      else if (nums[l] <= nums[mid]) {  // the left part of the array is unrotated
        if (nums[l] <= target && target < nums[mid])
          r = mid;
        else 
          l = mid + 1;
      } else {  // the right part of the array is unrotated
        if (nums[r] >= target && target > nums[mid])
          l = mid + 1;
        else
          r = mid;
      }
    }
    if (nums[l] == target)
      return true;
    return false;
  }    
}
