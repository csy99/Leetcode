/**
 * Created by csy99 on 5/12/20. 
 */
class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val-1 + left + right;
    }
}
