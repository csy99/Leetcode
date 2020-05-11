package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q145_Binary_Tree_Postorder_Traversal {
  // two stacks
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null) return res;
    Stack<TreeNode> s1 = new Stack();
    Stack<TreeNode> s2 = new Stack();
    s1.push(root);
    while (s1.size() > 0) {
      TreeNode cur = s1.pop();
      s2.push(cur);
      if (cur.left != null)
        s1.push(cur.left);
      if (cur.right != null)
        s1.push(cur.right);
    }
    
    while (s2.size() > 0) {
      res.add(s2.pop().val);
    }
    return res;
  }
 
  // one stack
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null) return res;
    Stack<TreeNode> s1 = new Stack();
    s1.push(root);
    TreeNode cur = root;
    TreeNode pre = null;
    while (s1.size() > 0) {
      cur = s1.peek();
      if ( (cur.left == null && cur.right == null) || 
          (pre != null && (pre == cur.left || pre == cur.right)) ) {
        res.add(cur.val);
        pre = s1.pop();
      } else {
        if (cur.right != null)
          s1.push(cur.right);
        if (cur.left != null)
          s1.push(cur.left);
      }
    }
    
    return res;
  }
  
    // simulate the reverse of postorder
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> deque = new LinkedList();
        if (root == null) return deque;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        while (st.size() > 0) {
            TreeNode cur = st.pop();
            deque.add(0, cur.val);
            if (cur.left != null)
                st.push(cur.left);
            if (cur.right != null)
                st.push(cur.right);
        }
        return deque;
    }
}
