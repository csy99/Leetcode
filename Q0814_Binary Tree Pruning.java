/**
 * Created by csy99 on 5/11/20. 
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;
        return check(root);
    }
    
    private TreeNode check(TreeNode root) {
        if (root == null)
            return root;
        root.left = check(root.left);
        root.right = check(root.right);
        if (root.left == null && root.right == null) {
            if (root.val == 0)
                return null; 
            else
                return root;
        }
        return root;
    }
}
