package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q111_Minimum_Depth_of_Binary_Tree {
  // recursion
  int depth = Integer.MAX_VALUE;
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    helper(root, 0);
    return depth;
  }
  
  private void helper(TreeNode root, int d) {
    if (root == null) {
      return;
    } 
    if (root.left == null && root.right == null) {
      depth = Math.min(depth, d + 1);
      return;
    } 
    helper(root.left, d + 1);
    helper(root.right, d + 1);
  }

    public int minDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int min = 0;
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            min++;

            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return min;
                else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }
        return min;
    }
}
