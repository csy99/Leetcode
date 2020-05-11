package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length != inorder.length)
      return null;
    return helper(inorder, postorder, postorder.length-1, 0, inorder.length-1);
  }
  
  private TreeNode helper(int[] inorder, int[] postorder, int root_idx, int in_st, int in_end) {
    if (root_idx >= postorder.length || in_st > in_end)
      return null;
    TreeNode root = new TreeNode(postorder[root_idx]);
    int i = in_st;
    while (i <= in_end) {
      if (inorder[i] == postorder[root_idx])
        break;
      i++;
    }
    int rightTreeLen = in_end - i;
    root.right = helper(inorder, postorder, root_idx-1, i+1, in_end);
    root.left = helper(inorder, postorder, root_idx-rightTreeLen-1, in_st, i-1);
    return root;
  }
}
