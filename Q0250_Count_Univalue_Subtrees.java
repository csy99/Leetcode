package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 * <p>
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * return 4.
 */
public class Q250_Count_Univalue_Subtrees {
  int cnt = 0;
  public int countUnivalSubtrees(TreeNode root) {
    isUnivalSubtree(root);
    return cnt;
  }
  
  private boolean isUnivalSubtree(TreeNode root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) {
      cnt += 1;
      return true;
    }
    boolean left = isUnivalSubtree(root.left);
    boolean right = isUnivalSubtree(root.right);
    if (!left || !right)
      return false;
    if (root.left != null && root.val != root.left.val)
      return false;
    if (root.right != null && root.val != root.right.val)
      return false;
    cnt += 1;
    return true;
  }
}
