package Leetcode;

/**
 * Created by csy99 on 4/17/20.
 */
public class Q136_Single_Number {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++)
            num ^= nums[i];
        return num;
    }
}
