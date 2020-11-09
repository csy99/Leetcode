/**
 * Created by csy99 on 11/9/20.
 */
class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        getSum(root);
        return res;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        int sum = left + root.val + right;
        res += Math.abs(left - right);
        return sum;
    }
}
