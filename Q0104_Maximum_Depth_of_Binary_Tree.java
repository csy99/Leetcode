package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q104_Maximum_Depth_of_Binary_Tree {
  // recursive
  int max = 0;
  public int maxDepth(TreeNode root) {
    helper(root, 0);
    return max;
  }
  
  private void helper(TreeNode root, int depth) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      max = Math.max(max, depth + 1);
      return;
    }
    helper(root.left, depth + 1);
    helper(root.right, depth + 1);
  }

    public int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return count;
    }
}
