package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q222_Count_Complete_Tree_Nodes {
    // time: O(log(n)^2): O(log n) steps, finding a height in each step costs O(log n).
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root);
        if (h - 1 == height(root.right))
            return (1 << h) + countNodes(root.right);
        else
            return (1 << h - 1) + countNodes(root.left);
    }
    
    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }
}
