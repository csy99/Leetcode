package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0034_Search_for_a_Range {
  public int[] searchRange(int[] nums, int target) {
    int[] res = {-1, -1};
    // corner case
    if (nums.length == 0 || nums.length == 1 && nums[0] != target)
      return res;
    else if (nums.length == 1)
      return new int[] {0, 0};
    int l = 0;
    int r = nums.length - 1;
    // find the first pos
    while (l < r) {
      int mid = l + (r - l)/2;
      if (nums[mid] >= target)  // search the left part
        r = mid;
      else
        l = mid + 1;
    }
    // check if target is found
    if (nums[l] != target)
      return res;
    res[0] = l;
    // reset pointers
    l = 0;
    r = nums.length - 1;
    // find the last pos
    while (l < r) {
      int mid = l + (r - l)/2;
      if (nums[mid] > target)  // search the left part
        r = mid;
      else
        l = mid + 1;
    }
    res[1] = nums[l] == target? l : l-1;
    return res;
  }
}
