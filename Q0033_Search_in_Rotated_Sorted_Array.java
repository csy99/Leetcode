package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q033_Search_in_Rotated_Sorted_Array {
  public int search(int[] nums, int target) {
    if (nums.length == 0)
      return -1;
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int mid = l + (r-l)/2;
      if (nums[mid] == target)
        return mid;
      if (nums[l] <= nums[mid]) {  // the left part of the array is unrotated
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
      return l;
    return -1;
  }
}
