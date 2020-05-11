package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {
  TreeNode ancestor = null;
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root, p, q);
    return ancestor;
  }
  
  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return false;
    int left = dfs(root.left, p, q) ? 1 : 0;
    int right = dfs(root.right, p, q) ? 1 : 0;
    // check if root is either p or q
    int mid = root == p || root == q ? 1 : 0;
    if (left + mid + right > 1)
      ancestor = root;
    return left + mid + right > 0;
  }
}
