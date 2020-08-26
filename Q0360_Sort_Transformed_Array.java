package Leetcode;

/**
 * Created by csy99 on 8/26/20.
 * <p>
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * <p>
 * The returned array must be in sorted order.
 * <p>
 * Expected time complexity: O(n)
 * <p>
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * <p>
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5Result: [-23, -5, 1, 7]
 */

public class Q360_Sort_Transformed_Array {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (a > 0)  // 两头的数会比较大
            return helper1(nums, a, b, c);
        else
            return helper2(nums, a, b, c);
    }
    
    private int[] helper1(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int p = 0; 
        int q = n-1;
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--) {
            int front = getVal(nums, p, a, b, c);
            int end = getVal(nums, q, a, b, c);
            if (front >= end) {
                res[i] = front;
                p++;
            } else {
                res[i] = end;
                q--;
            }
        }
        return res;
    }
    
    private int[] helper2(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int p = 0; 
        int q = n-1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int front = getVal(nums, p, a, b, c);
            int end = getVal(nums, q, a, b, c);
            if (front <= end) {
                res[i] = front;
                p++;
            } else {
                res[i] = end;
                q--;
            }
        }
        return res;
    }
    
    private int getVal(int[] nums, int i, int a, int b, int c) {
        return a*nums[i]*nums[i] + b*nums[i] + c;  
    }
}
