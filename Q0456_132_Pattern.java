package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 8/31/20.
 */
public class Q456_132_Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        // mono stack: non increasing order
        Stack<Integer> pos = new Stack();
        int[] min_front = new int[n];
        min_front[0] = nums[0];
        for (int i = 1; i < n; i++)
            min_front[i] = Math.min(nums[i], min_front[i-1]); 
        for (int j = n-1; j > 0; j--) {
            while (pos.size() > 0 && nums[pos.peek()] < nums[j]) {
                if (nums[pos.peek()] > min_front[j-1])
                    return true;
                pos.pop();
            }
            pos.push(j);
        }
        return false;
    }
}
