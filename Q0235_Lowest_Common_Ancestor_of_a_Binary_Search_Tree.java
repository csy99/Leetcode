package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 *
 * Given a binary search tree (BST),
 * find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 */
public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
  // recursion
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < root.val && q.val < root.val)
      return lowestCommonAncestor(root.left, p, q);
    if (p.val > root.val && q.val > root.val)
      return lowestCommonAncestor(root.right, p, q);
    return root;
  }

  // iteration
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode cur = root;
    while (cur != null) {
      if (p.val < cur.val && q.val < cur.val)
        cur = cur.left;
      else if (p.val > cur.val && q.val > cur.val)
        cur = cur.right;
      else 
        return cur;
    }
    return null;
  }
}
