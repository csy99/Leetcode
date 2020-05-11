package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q099_Recover_Binary_Search_Tree {
    TreeNode x = null;
    TreeNode y = null;
    TreeNode pre = null;
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && root.val < pre.val) {
            y = root;
            if (x == null) x = pre;
            else return;
        }
        pre = root;
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
