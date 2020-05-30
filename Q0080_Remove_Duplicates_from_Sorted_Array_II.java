package Leetcode;

import Leetcode.Util.ListNode;

/**
 * Created by csy99 on 5/30/20.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Q080_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int len = 1;
        int cnt = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                cnt++;
            } else {
                cnt = 1;
                pre = nums[i];
            }
            if (cnt > 2)
                len--;
            nums[len] = nums[i];
            len++;
        }
        return len;
    }
}
