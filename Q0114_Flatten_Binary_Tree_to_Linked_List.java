package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null) 
            return;
        flatten(root.left);
        flatten(root.right);
        if (root.left == null) return;
        TreeNode rightTree = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode lastInLeft = root;
        while (lastInLeft.right != null)
            lastInLeft = lastInLeft.right;
        lastInLeft.right = rightTree;
    }
}
