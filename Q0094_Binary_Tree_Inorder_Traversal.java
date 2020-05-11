package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q094_Binary_Tree_Inorder_Traversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null) return res;
    Stack<TreeNode> st = new Stack();
    TreeNode cur = root;
    while (cur != null || !st.isEmpty()) {
      while (cur != null) {
        st.push(cur);
        cur = cur.left;
      }
      cur = st.pop();
      res.add(cur.val);
      cur = cur.right;
    }
    return res;
  }
}
