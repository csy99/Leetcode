package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q376_Wiggle_Subsequence {
    // dp, time: O(n), space: O(n)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] pos = new int[n];
        int[] neg = new int[n];
        pos[0] = 1;
        neg[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                pos[i] = neg[i-1]+1;
                neg[i] = neg[i-1];
            } else if (nums[i] < nums[i-1]) {
                neg[i] = pos[i-1]+1;
                pos[i] = pos[i-1];
            } else {
                pos[i] = pos[i-1];
                neg[i] = neg[i-1];
            }
        }
        return Math.max(pos[n-1],neg[n-1]);
    }
  
  // dp, space: O(1)
  public int wiggleMaxLength(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int up = 1;  // the last trend for the wiggle sequence is going up
    int down = 1;  // the last trend for the wiggle sequence is going down
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1])
        up = down + 1;
      else if (nums[i] < nums[i - 1])
        down = up + 1;
    }
    return Math.max(up, down);
  }

    // greedy, time: O(n), space: O(1)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int prevDiff = nums[1] - nums[0];
        int count = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i-1];
            if (diff > 0 && prevDiff <= 0 ||
               diff < 0 && prevDiff >= 0) {
                count++;
                prevDiff = diff;
            }
        }
        return count;
    }
}
