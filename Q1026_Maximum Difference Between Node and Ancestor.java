/**
 * Created by csy99 on 11/9/20.
 */
class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        traverse(root, root.val, root.val);
        return res;
    }
    
    private void traverse(TreeNode root, int preMin, int preMax) {
        if (root == null) return;
        int diff1 = Math.abs(preMin - root.val);
        res = Math.max(diff1, res);
        int diff2 = Math.abs(preMax - root.val);
        res = Math.max(diff2, res);
        preMin = Math.min(preMin, root.val);
        preMax = Math.max(preMax, root.val);
        traverse(root.left, preMin, preMax);
        traverse(root.right, preMin, preMax);
    }
}
