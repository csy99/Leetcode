package Leetcode;

import Leetcode.Util.TreeNode;
import com.whitespace.raghav.BinaryTree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/4/20.
 * <p>
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 */
public class Q366_Find_Leaves_of_Binary_Tree {
  int maxHeight = 0;
  HashMap<Integer, List<Integer>> heights = new HashMap();
  
  public List<List<Integer>> findLeaves(TreeNode root) {
    height(root);
    List<List<Integer>> res = new ArrayList();
    for (int h = 1; h <= maxHeight; h++) 
      res.add(heights.get(h));
    return res;
  }
  
  private int height(TreeNode root) {
    if(root == null) return 0;
    int height = Math.max(height(root.left), height(root.right)) + 1;
    if (heights.containsKey(height)) {
      heights.get(height).add(root.val);
    } else {
      List<Integer> h = new ArrayList();
      h.add(root.val);
      heights.put(height, h);
    }
    maxHeight = Math.max(maxHeight, height);
    return height;
  }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        d.left = f;
        e.left = g;

        c.left = i;
        c.right = h;

        h.left = j;

        Q366_Find_Leaves_of_Binary_Tree sol = new Q366_Find_Leaves_of_Binary_Tree();
        List<List<Integer>> res = sol.findLeaves(a);
        System.out.println(res);

    }
}
