package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q153_Find_Minimum_in_Rotated_Sorted_Array {
  // binary search
  // time: O(log n), space: O(1)
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0)
      return -1;
    int l = 0;
    int r = nums.length - 1;
    // nums[l] > nums[r] means the array is not in the sorted part yet
    // once break out, the array is in the sorted part
    // return the first element in this part
    while (l < r && nums[l] > nums[r]) {
      int mid = l + (r-l)/2;
      // nums[mid] == nums[l] happens when l == mid
      if (nums[mid] >= nums[l]) {  // the min is on the right half
        l = mid + 1;
      } else {  // the min is on the left half
        r = mid;
      }
    }
    return nums[l];
  }
    
    // recursion
    // time: O(log n), space: O(log n)
    // The time complexity is O(log n), because in each recursion, there will be at least
    // one part of the array is sorted. Returning the min value of a sorted array is O(1).
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);     
    }
  
    private int findMin(int[]nums, int l, int r) {
        if (l == r)  // only 1 element in the array
            return nums[l];
        if (nums[l] < nums[r])
            return nums[l];
        int mid = l + (r-l)/2;
        return Math.min(findMin(nums, l, mid), findMin(nums, mid+1, r));
    }
}
