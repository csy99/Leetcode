package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q110_Balanced_Binary_Tree {
    // HashMap<TreeNode, Integer> h = new HashMap();
    public boolean isBalanced(TreeNode root) {
        if (height(root) < 0)
            return false;
        return true;
    }
    
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        // if (h.containsKey(root))
        //     return h.get(root);
        if (root.left == null && root.right == null) {
            // h.put(root, 1);
            return 1;
        }
        int leftHi = height(root.left);
        int rightHi = height(root.right);
        if (leftHi == -1 || rightHi == -1)
            return -1;
        if (Math.abs(leftHi - rightHi) > 1) 
            return -1;
        int curHi = 1 + Math.max(leftHi, rightHi);
        // h.put(root, curHi);
        return curHi;
    }
}
