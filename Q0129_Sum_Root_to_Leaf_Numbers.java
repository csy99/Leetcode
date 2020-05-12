package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 * <p>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class Q129_Sum_Root_to_Leaf_Numbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
      helper(root, 0);
      return sum;
    }

    private void helper(TreeNode root, int cur) {
      if (root == null) {
        return;
      }
      if (root.left == null && root.right == null) {
        sum += cur * 10 + root.val;
        return;
      }
      cur = cur * 10 + root.val;
      helper(root.left, cur);
      helper(root.right, cur);
    }
}
