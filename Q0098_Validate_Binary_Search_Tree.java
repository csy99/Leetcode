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
