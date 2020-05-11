package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 4/1/20.
 */
public class Q112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
