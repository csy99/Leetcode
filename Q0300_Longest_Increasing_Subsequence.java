package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0300_Longest_Increasing_Subsequence {
    // dp
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int r = 0; r < nums.length; r++) {
            for (int l = 0; l < r; l++) {
                if (nums[l] < nums[r])
                    dp[r] = Math.max(dp[r], dp[l] + 1);
            }
        }
        int max = 0;
        for (int r = 0; r < nums.length; r++) 
            max = Math.max(max, dp[r]);
        return max + 1;
    }
  
  // binary search
  public int lengthOfLIS(int[] nums) {
    int[] sorted = new int[nums.length];
    int size = 0;
    for (int i: nums) {
      int l = 0;
      int r = size;
      // find a place to insert the new number
      while (l < r) {
        int mid = (l+r)/2;
        if (sorted[mid] < i)
          l = mid+1;
        else
          r = mid;
      }
      sorted[l] = i;
      if (l == size)  // the new number is inserted at the back
        size++;
    }
    return size;
  }
}
