/**
 * Created by csy99 on 5/18/20.
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        traverseAndInsert(root, val);
        return root;
    }
    
    private void traverseAndInsert(TreeNode root, int val) {
        if (root == null)  // should not happen
            return;
        if (val < root.val) {
            if (root.left == null)
                root.left = new TreeNode(val);
            else
                traverseAndInsert(root.left, val);
        } else {
            if (root.right == null)
                root.right = new TreeNode(val);
            else
                traverseAndInsert(root.right, val);
        }
    }
}
