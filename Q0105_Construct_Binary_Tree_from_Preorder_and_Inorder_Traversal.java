package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length != preorder.length)
      return null;
    return helper(preorder, inorder, 0, 0, inorder.length-1);
  }
  
  private TreeNode helper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end) {
    if (pre_st >= preorder.length || in_st > in_end)
      return null;
    TreeNode root = new TreeNode(preorder[pre_st]);
    int i = in_st;
    while (i <= in_end) {
      if (inorder[i] == root.val)
        break;
      i++;
    }
    root.left = helper(preorder, inorder, pre_st+1, in_st, i-1);
    root.right = helper(preorder, inorder, pre_st+(i-in_st+1), i+1, in_end);
    return root; 
  }
}
