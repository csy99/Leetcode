package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by csy99 on 4/10/20.
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * Java Solution
 * <p>
 * For each node, its left child's degree is -1 and is right child's degree is +1.
 * We can do a level order traversal and save the degree information.
 */

public class Q314_Binary_Tree_Vertical_Order_Traversal {
  class Node {
    TreeNode node;
    int coord;
    
    public Node(TreeNode n, int c) {
      node = n;
      coord = c;
    }
  }
  
  public List<List<Integer>> verticalOrder(TreeNode root) {
    HashMap<Integer, List<Integer>> map = new HashMap();
    List<List<Integer>> res = new ArrayList();
    if (root == null) return res;
    Queue<Node> q = new LinkedList();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    q.offer(new Node(root, 0));
    while (q.size() > 0) {
      Node cur = q.poll();
      int coord = cur.coord;
      min = Math.min(min, coord);
      max = Math.max(max, coord);
      if (!map.containsKey(coord)) 
        map.put(coord, new ArrayList());
      map.get(coord).add(cur.node.val);
      if (cur.node.left != null)
        q.offer(new Node(cur.node.left, coord-1));
      if (cur.node.right != null)
        q.offer(new Node(cur.node.right, coord+1));
    }
    for (int i = min; i <= max; i++) 
      res.add(map.get(i));
    return res;
  }
}
