package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 5/18/20.
 */
public class Q530_Minimum_Absolute_Difference_in_BST {
    // find range, time: O(n)
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
    
    
    
     // find predecessor and successor, time: O(n^2)
    int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return minDiff;
    }
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        
        int pred_val = getPred(root);
        if (pred_val >= 0)
            minDiff = Math.min(minDiff, root.val - pred_val);
        
        int succ_val = getSucc(root);
        if (succ_val >= 0)
            minDiff = Math.min(minDiff, succ_val - root.val);
        
        traverse(root.left);
        traverse(root.right);
    }
    
    private int getSucc(TreeNode root) {
        if (root.right == null) return -1;
        TreeNode cur = root.right;
        while (cur.left != null)
            cur = cur.left;
        return cur.val;
    }
    
    private int getPred(TreeNode root) {
        if (root.left == null) return -1;
        TreeNode cur = root.left;
        while (cur.right != null)
            cur = cur.right;
        return cur.val;
    }
}
