package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q101_Symmetric_Tree {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return symHelper(root.left, root.right);
  }
  
  private boolean symHelper(TreeNode left, TreeNode right) {
    if (left == null && right == null)
      return true;
    if (left == null || right == null)
      return false;
    if (left.val != right.val)
      return false;
    return symHelper(left.left, right.right) && symHelper(left.right, right.left);
  }

    // Iterative
    public boolean isSymmetric(TreeNode root) {
      if (root == null)
        return true;
      Stack<TreeNode> st = new Stack<>();
      TreeNode left = root.left;
      TreeNode right = root.right;
      st.push(left);
      st.push(right);
      while (!st.isEmpty()) {
        right = st.pop();
        left = st.pop();
        if (left == null && right == null)  // still need to compare other nodes
          continue;
        else if (left == null || right == null)
          return false;
        else if (right.val != left.val)
          return false;
        st.push(left.left);
        st.push(right.right);
        st.push(right.left);
        st.push(left.right);
      }
      return true;
    }

    
}
