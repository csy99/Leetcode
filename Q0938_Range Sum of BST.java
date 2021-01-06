/**
 * Created by csy99 on 1/6/21.
 */
class Solution {
    int res = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }
    
    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) 
            res += root.val;
        if (root.val <= high)
            dfs(root.right, low, high);
        if (root.val >= low)
            dfs(root.left, low, high);
    }
}
