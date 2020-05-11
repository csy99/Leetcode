package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length-1);
  }

  private TreeNode build(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = (l + r) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, l, mid-1);
    root.right = build(nums, mid+1, r);
    return root;
  }
}
