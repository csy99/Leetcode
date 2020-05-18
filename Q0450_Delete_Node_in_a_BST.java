package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 5/18/20.
 */
public class Q450_Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // cur is the node to be deleted
        if (root.left != null && root.right != null) {  // has two children
            // find successor
            TreeNode parent = root;
            TreeNode succ = root.right;
            while (succ.left != null) {
                parent = succ;
                succ = succ.left;
            }
            if (parent != root) {  // this is important
                parent.left = succ.right;
                succ.right = root.right;
            }
            succ.left = root.left;
            return succ;
        } else {  // at most one child
            return root.left != null? root.left : root.right;
        }
    }
}
