/**
 * Created by csy99 on 5/11/20. 
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (checkAndPrune(root))
            return root;
        return null;
    }
    
    private boolean checkAndPrune(TreeNode root) {
        if (root == null)
            return false;
        boolean left = checkAndPrune(root.left);
        boolean right = checkAndPrune(root.right);
        if (!left)
            root.left = null;
        if (!right)
            root.right = null;
        if (root.val == 1)
            return true;
        return left || right;
    }
}
