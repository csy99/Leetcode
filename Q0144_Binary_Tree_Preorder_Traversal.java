package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q144_Binary_Tree_Preorder_Traversal {
  // recursion
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    helper(root, res);
    return res;
  }
  
  private void helper(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    list.add(root.val);
    helper(root.left, list);
    helper(root.right, list);
  }
    
  // iteration
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null)
      return res;
    Stack<TreeNode> st = new Stack();
    st.push(root);
    while (st.size() > 0) {
      TreeNode node = st.pop();
      res.add(node.val);
      if (node.right != null)
        st.push(node.right);
      if (node.left != null)
        st.push(node.left);
    }
    return res;
  }    
}
