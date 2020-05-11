package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by csy99 on 4/5/20.
 */
public class Q107_Binary_Tree_Level_Order_Traversal_II {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    if (root == null)
      return new ArrayList<>();
    List<List<Integer>> res = new ArrayList();
    Queue<TreeNode> q = new LinkedList();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> level = new ArrayList();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        level.add(cur.val);
        if (cur.left != null) 
          q.offer(cur.left);
        if (cur.right != null) 
          q.offer(cur.right);
      }
      res.add(0, level);
    }
    return res;
  }
}
