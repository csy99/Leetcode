package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/4/20.
 * <p>
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 */

public class Q298_Binary_Tree_Longest_Consecutive_Sequence {
  // recursion  
  int longest = 0;
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    helper(root, 0, root.val);
    return longest;
  }
  
  private void helper(TreeNode root, int len, int prev) {
    if (root == null)
      return;
    if (root.val == prev + 1) 
      len += 1;
    else 
      len = 1;
    longest = Math.max(len, longest);
    helper(root.left, len, root.val);
    helper(root.right, len, root.val);
  }

    // Iterative
    public int longestConsecutiveIterative(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> sizeQueue = new LinkedList<Integer>();

        nodeQueue.offer(root);
        sizeQueue.offer(1);
        int max = 1;

        while (!nodeQueue.isEmpty()) {
            TreeNode head = nodeQueue.poll();
            int size = sizeQueue.poll();

            if (head.left != null) {
                int leftSize = size;
                if (head.val == head.left.val - 1) {
                    leftSize++;
                    max = Math.max(max, leftSize);
                } else {
                    leftSize = 1;
                }

                nodeQueue.offer(head.left);
                sizeQueue.offer(leftSize);
            }

            if (head.right != null) {
                int rightSize = size;
                if (head.val == head.right.val - 1) {
                    rightSize++;
                    max = Math.max(max, rightSize);
                } else {
                    rightSize = 1;
                }

                nodeQueue.offer(head.right);
                sizeQueue.offer(rightSize);
            }


        }

        return max;
    }
}
