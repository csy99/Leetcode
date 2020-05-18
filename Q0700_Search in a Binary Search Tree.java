/**
 * Created by csy99 on 5/18/20.
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        if (val < root.val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }
}
