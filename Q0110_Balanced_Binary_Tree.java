package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q110_Balanced_Binary_Tree {
  public boolean isBalanced(TreeNode root) {
    if (height(root, 0) == -1)
      return false;
    return true;
  }
  
  private int height(TreeNode root, int depth) {
    if (depth == -1) return -1;
    if (root == null) return depth;
    int left = height(root.left, depth + 1);
    int right = height(root.right, depth + 1);
    if (Math.abs(left - right) > 1)
      return -1;
    return Math.max(left, right);
  }
}
