package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q124_Binary_Tree_Maximum_Path_Sum {
  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    maxSum(root, 0);
    return max;
  }
  
  // return value: the root is used, at most one child is used
  private int maxSum(TreeNode root, int sum) {
    if (root == null) return 0;
    int left = Math.max(0, maxSum(root.left, sum));
    int right = Math.max(0, maxSum(root.right, sum));
    max = Math.max(max, left + right + root.val);
    return Math.max(left, right) + root.val;
  }
}
