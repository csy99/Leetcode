package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 4/5/20.
 */
public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    if(root == null) return res;
    Deque<TreeNode> deque = new LinkedList();
    deque.offerLast(root);
    int depth = 0;
    while(!deque.isEmpty()) {
      int size = deque.size();
      List<Integer> level = new ArrayList();
      for(int i = 0; i < size; i++) {
        TreeNode cur;
        if(depth % 2 == 0) { // FIFO
          cur = deque.removeFirst();
          if(cur.left != null)
            deque.offerLast(cur.left);
          if(cur.right != null) 
            deque.offerLast(cur.right);
        } else { // LIFO
          cur = deque.removeLast();
          if(cur.right != null) 
            deque.offerFirst(cur.right);
          if(cur.left != null)
            deque.offerFirst(cur.left);
        }
        level.add(cur.val);
      }
      depth++;
      res.add(level);
    }
    return res;
  }
}
