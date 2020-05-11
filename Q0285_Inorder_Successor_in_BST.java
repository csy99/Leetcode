package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/7/20.
 * <p>
 * Given a binary search tree and a node in it,
 * find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree,
 * return null.
 */
public class Q285_Inorder_Successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (root == null || p == null) return null;
      if (p.right != null)
        return findMin(p.right);
      // when p doesn't have right child, its parent should be its successor
      TreeNode runner = root;
      TreeNode suc = null;
      while (runner != null) {
        if (runner.val < p.val) {
          // its parent is surely larger than p, so no need to update suc
          runner = runner.right;
        } else if (runner.val > p.val) {
          suc = runner;
          runner = runner.left;
        } else  // find p
          break;
      }
      return suc;
    }
    
    private TreeNode findMin(TreeNode root) {
      TreeNode cur = root;
      while (cur.left != null) {
        cur = cur.left;
      }
      return cur;
    }
}
