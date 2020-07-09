package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 7/9/20.
 * <p>
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 * For example:
 * Given a binary tree {1,2,3,4,5},
 * 1
 * / \
 * 2   3
 * /  \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 4
 * /  \
 * 5   2
 * /  \
 * 3   1
 */
public class Q156_Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        // left child of the root will become new root;
        TreeNode leftChild = root.left;
        TreeNode newRoot = upsideDownBinaryTree(leftChild);
        leftChild.left = root.right;
        leftChild.right = root;
        root.left = null;
        root.right = null;
        return newRoot;        
    }
}
