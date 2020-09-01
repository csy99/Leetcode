package Leetcode;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q453_Minimum_Moves_to_Equal_Array_Elements {
    // The key idea: increase n-1 elements by 1 to make all elements equal has the same effect as decrease 1 element by 1 to make them equal. 
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - min * nums.length;
    }
}
