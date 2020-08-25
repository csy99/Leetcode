package Leetcode;

/**
 * Created by csy99 on 8/25/20.
 */
public class Q404_Sum_of_Left_Leaves {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return res;
    }
    
    private void helper(TreeNode root, boolean left) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && left) {
            res += root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }
}
