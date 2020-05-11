package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 4/5/20.
 */
public class Q199_Binary_Tree_Right_Side_View {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList();
    if (root == null)
      return res;
    Queue<TreeNode> q = new LinkedList();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      TreeNode last = null;
      for (int i = 0; i < size; i++) {
        last = q.poll();
        if (last.left != null)
          q.offer(last.left);
        if (last.right != null)
          q.offer(last.right);
      }
      res.add(last.val);
    }
    return res;
  }
}
