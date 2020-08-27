package Leetcode;

/**
 * Created by csy99 on 8/27/20.
 * <p>
 * Given a non-empty array of integers,
 * return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 * <p>
 * https://leetcode.com/problems/third-maximum-number/
 */
public class Q414_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        long m1 = (long)Integer.MIN_VALUE - 10;
        long m2 = (long)Integer.MIN_VALUE - 10;
        long m3 = (long)Integer.MIN_VALUE - 10;
        for (int i = 0; i < n; i++) {
            if (nums[i] == m1 || nums[i] == m2 || nums[i] == m3)
                continue;
            if (nums[i] > m1) {
                m3 = m2;
                m2 = m1;
                m1 = nums[i];
            } else if (nums[i] > m2) {
                m3 = m2;
                m2 = nums[i];
            } else if (nums[i] > m3)
                m3 = nums[i];
        }
        if (m3 < Integer.MIN_VALUE)
            return (int) m1;
        return (int) m3;
    }
}
