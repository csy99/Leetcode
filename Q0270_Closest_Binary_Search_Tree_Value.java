package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/7/20.
 * <p>
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 */
public class Q270_Closest_Binary_Search_Tree_Value {
  int closest = 0;
  public int closestValue(TreeNode root, double target) {
    if (root == null) return 0;
    closest = root.val;
    dfs(root, target);
    return closest;
  }
  
  private void dfs(TreeNode root, double target) {
    if (root == null) return;
    if (Math.abs(closest - target) > Math.abs(root.val - target))
      closest = root.val;
    if (root.val < target)
      dfs(root.right, target);
    else
      dfs(root.left, target);
  }
}
