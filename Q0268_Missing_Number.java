package Leetcode;

/**
 * Created by csy99 on 4/18/20.
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 */
public class Q268_Missing_Number {
    // Bit Manipulation
    public int missingNumber(int[] nums) {
        int num = nums.length;
        for (int i = 0; i < nums.length; i++)
            num ^= (nums[i] ^ i);
        return num;
    }
    
    // Gauss' Formula
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n*(n+1)/2;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        return expected - sum;
    }    
}
