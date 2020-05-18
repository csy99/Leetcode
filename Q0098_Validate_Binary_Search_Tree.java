package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q098_Validate_Binary_Search_Tree {
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
  
  private boolean helper(TreeNode root, Integer min, Integer max) {
    if (root == null) return true;
    if (min != null && root.val <= min || max != null && root.val >= max) return false;
    return helper(root.left, min, root.val) && helper(root.right, root.val, max);
  }
}

// a little faster
class Solution {
    boolean valid = true;
    public boolean isValidBST(TreeNode root) {
        range(root);
        return valid;
    }
    
    private int[] range(TreeNode root) {
        if (!valid) return null;
        if (root == null) return null;
        int[] range = new int[] {root.val, root.val};
        if (root.left == null && root.right == null)
            return range;
        int[] left = range(root.left);
        int[] right = range(root.right);
        if (left != null) {
            range[0] = left[0];
            if (root.val <= left[1])
                valid = false;
        }
        if (right != null) {
            range[1] = right[1];
            if (root.val >= right[0])
                valid = false;
        }
        return range;
    }
}
