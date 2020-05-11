package Leetcode;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 1)
            return 0;
        else if (nums.length == 2) {
            return (nums[0] > nums[1]) ? 0 : 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        // if no peak is found, then arr is sorted (asc or desc), return highest
        return (nums[0] > nums[nums.length - 1]) ? 0 : nums.length - 1;
    }
}
