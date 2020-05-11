package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q102_Binary_Tree_Level_Order_Traversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList();
    if (root == null) return res;
    TreeNode last = root;
    TreeNode nextLast = root.right;
    Queue<TreeNode> q = new LinkedList();
    q.offer(root);
    while(!q.isEmpty()) {
      List<Integer> level = new LinkedList();
      int size = q.size();
      while (size > 0) {
        TreeNode cur = q.poll();
        if (cur.left != null) {
          q.offer(cur.left);
          nextLast = cur.left;
        }
        if (cur.right != null) {
          q.offer(cur.right);
          nextLast = cur.right;
        }
        level.add(cur.val);
        if (cur == last)
          last = nextLast;
        size--;
      }
      
      res.add(level);
    }
    return res;
  }
}
