package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by csy99 on 7/9/20.
 * <p>
 * Given an array of numbers,
 * verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 */
public class Q255_Verify_Preorder_Sequence_in_Binary_Search_Tree {
    
    // recursion (TLE), time: O(n^2), space: O(1)
    public boolean verifyPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return true;
        long low = (long) Integer.MIN_VALUE - 1;
        long high = (long) Integer.MAX_VALUE + 1;
        return check(preorder, 0, n-1, low, high);
    }
    
    private boolean check(int[] arr, int l, int r, long low, long high) {
        if (l > r) return true;
        if (arr[l] <= low || arr[r] >= high)
            return false;
        int firstLarger = l+1;
        while (firstLarger <= r && arr[firstLarger] < arr[l])
            firstLarger++;
        return check(arr, l+1, firstLarger-1, low, arr[l]) &&
            check(arr, firstLarger, r, arr[l], high);
    }
    
    // Use a stack to store the numbers less than num,
    // and a list to store the numbers in an ascending order.
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) 
            return true;

        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> list = new ArrayList<>();

        for (int num : preorder) {
            // If the in-order list descends, return false.
            if (!list.isEmpty() && num < list.get(list.size() - 1)) 
                return false;
            while (!stack.isEmpty() && num > stack.peek()) 
                list.add(stack.pop());
            stack.push(num);
        }
        return true;
    }

    //Solution using one stack:
    //Since the in-order list only stores the number in ascending order.
    //We can use a variable to store only the last i.e max value.

    public boolean verifyPreorderTwo(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < max) 
                return false;
            while (!stack.isEmpty() && num > stack.peek()) 
                max = stack.pop();
            stack.push(num);
        }
        return true;
    }

    // , time: O(n), space: O(1)
    public boolean verifyPreorderThree(int[] preorder) {
        if (preorder == null || preorder.length <= 1) 
            return true;
        int i = -1;
        int max = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < max) 
                return false;
            while (i >= 0 && num > preorder[i]) {
                max = preorder[i];
                i--;
            }
            i++;
            preorder[i] = num;
        }
        return true;
    }
}
