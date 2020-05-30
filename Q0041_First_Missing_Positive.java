package Leetcode;

/**
 * Created by csy99 on 5/30/20.
 * <p>
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Q041_First_Missing_Positive {
    // time: O(n), space: O(n)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;
        int[] bucket = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n)
                bucket[nums[i]] = nums[i];
        }
        for (int i = 1; i <= n; i++) {
            if (bucket[i] == 0)
                return i;
        }
        return n+1;
    }
    
    // time: O(n), space: O(1)
    public int firstMissingPositive(int[] nums) {
      if (nums == null || nums.length == 0)
        return 1;  // 1 is smallest pos int
      for (int i = 0 ; i < nums.length; i++) {
        while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
          int tmp = nums[nums[i]-1];
          nums[nums[i]-1] = nums[i];
          nums[i] = tmp;
        }
      }
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1)
          return i + 1;
      }
      return nums.length + 1;
    }
}
