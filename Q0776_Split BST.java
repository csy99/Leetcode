/**
 * Created by csy99 on 10/9/21.
 */
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val <= target) {
            TreeNode[] bns = splitBST(root.right, target);
            root.right = bns[0];
            bns[0] = root;
            return bns;
        } else {
            TreeNode[] bns = splitBST(root.left, target);
            root.left = bns[1];
            bns[1] = root;
            return bns;
        }
    }
}
