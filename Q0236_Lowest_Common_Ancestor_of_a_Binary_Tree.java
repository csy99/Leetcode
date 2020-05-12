package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    // recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null || right == null)
            return left == null ? right : left;
        return root;
    }
  
    // dfs
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
