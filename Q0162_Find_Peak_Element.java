package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0162_Find_Peak_Element {
      public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r-l)/2;
                if (nums[mid] < nums[mid+1])
                    l = mid+1;
                else
                    r = mid;
            }
            return l;
      }
}
