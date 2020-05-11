package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/7/20.
 */
public class Q230_Kth_Smallest_Element_in_a_BST {
    // nums: idx of the node in the Tree
    int nums = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.left, k);
        if (++nums == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
