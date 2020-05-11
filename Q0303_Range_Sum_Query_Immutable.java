package Leetcode;

/**
 * Created by csy99 on 4/19/20.
 */
public class Q303_Range_Sum_Query_Immutable {
    private int[] sum;
    
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            sum[i+1] = sum[i] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}
