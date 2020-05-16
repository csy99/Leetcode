package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            if (nums[l] < nums[r])
                break;
            int mid = l + (r - l) / 2;
            if (nums[l] == nums[r])
                l++;
            else if (nums[l] <= nums[mid])
                l = mid + 1;
            else
                r = mid;
        }
        return nums[l];
    }
}
