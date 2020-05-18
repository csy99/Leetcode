package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 5/18/20.
 */
public class Q530_Minimum_Absolute_Difference_in_BST {
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        range(root);
        return res;
    }
    
    private int[] range(TreeNode root) {
        if (root == null || res == 1)  // not possible to find a smaller result in latter case
            return null;
        int[] cur = new int[] {root.val, root.val};
        int[] left = range(root.left);
        int[] right = range(root.right);
        if (left != null) {
            cur[0] = left[0];
            res = Math.min(res, root.val-left[1]);
        }
        if (right != null) {
            cur[1] = right[1];
            res = Math.min(res, right[0]-root.val);
        }
        return cur;
    }
}
