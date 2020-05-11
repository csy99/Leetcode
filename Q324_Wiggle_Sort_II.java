package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q324_Wiggle_Sort_II {
  // time: O(n), space: O(n)
  public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    int l = (nums.length-1)/2;  // smaller part of the array
    int r = nums.length - 1;  // larger part of the array
    int pos = 0;
    int[] res = new int[nums.length];
    while (l >= 0 || r > (nums.length-1)/2) {
      if (pos % 2 == 0) 
        res[pos++] = nums[l--];
      else
        res[pos++] = nums[r--];
    }
    for (int i = 0; i < nums.length; i++)
      nums[i] = res[i];
  }
}
