package Leetcode;

/**
 * Created by csy99 on 3/26/20.
 */
public class Q031_Next_Permutation {
  public void nextPermutation(int[] nums) {
    if (nums.length < 2) return;
    int replace = nums.length - 2;
    while (replace >= 0) {
      if (nums[replace] < nums[replace+1])
        break;
      replace--;
    }
    if (replace < 0) {  // the array is in descending order
      Arrays.sort(nums);
      return;
    }
    // find the smallest number that is greater than the current number 
    int nxt = replace + 1;
    while (nxt < nums.length && nums[nxt] > nums[replace]) {
      nxt++;
    }
    nxt--;
    int tmp = nums[replace];
    nums[replace] = nums[nxt];
    nums[nxt] = tmp;
    Arrays.sort(nums, replace+1, nums.length);
  }
}
