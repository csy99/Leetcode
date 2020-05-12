/**
 * Created by csy99 on 5/12/20. 
 */
class Solution {
    public int distributeCoins(TreeNode root) {
        int[] res = helper(root);
        return res[1];
    }
    
    private int[] helper(TreeNode root) {
        int[] cur = new int[2];
        if (root == null)
            return cur;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        cur[0] = (root.val-1) + left[0] + right[0];
        cur[1] = Math.abs(cur[0]) + left[1] + right[1];
        return cur;
    }
}
