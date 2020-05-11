package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q337_House_Robber_III {
  public int rob(TreeNode root) {
    int[] max = helper(root);
    return Math.max(max[0], max[1]);
  }
  
  // return value: 
  // arr[0]: max value can be obtained if not stealing this house
  // arr[1]: max value can be obtained if stealing this house
  private int[] helper(TreeNode root) {
    if (root == null) 
      return new int[] {0, 0};
    int[] value = new int[2];
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    value[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    value[1] = root.val + left[0] + right[0];
    return value;
  }
}
