package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 5/12/20.
 */
public class Q543_Diameter_of_Binary_Tree {
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        findPath(root);
        return longest;
    }
    
    private int findPath(TreeNode root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return 0;
        int left = findPath(root.left);
        int right = findPath(root.right);
        int path = 2 + left + right;  // 2 stand for edges from root to both left and right subtree
        longest = Math.max(path, longest);
        return 1 + Math.max(left, right);
    }
}
