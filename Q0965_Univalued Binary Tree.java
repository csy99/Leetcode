/**
 * Created by csy99 on 5/11/20.
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return checkUni(root, root.val);
    }
    
    private boolean checkUni(TreeNode root, int v) {
        if (root == null)
            return true;
        if (root.val != v)
            return false;
        return checkUni(root.left, v) && checkUni(root.right, v);
    }
}
