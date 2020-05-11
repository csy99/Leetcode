package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0154_Find_Minimum_in_Rotated_Sorted_Array_II {
  public int findMin(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 2)
      return Math.min(nums[0], nums[1]);
    int l = 0;
    int r = nums.length - 1;
    while (l < r && nums[l] >= nums[r]) {
      int mid = l +(r-l)/2;
      if (nums[l] == nums[mid] && nums[mid] == nums[r])  // no enough info
        l++;
      else if (nums[l] <= nums[mid])  // the left half is sorted
        l = mid+1;
      else
        r = mid;
    }
    return nums[l];
  }
}
