/**
 * Created by csy99 on 5/11/20.
 */
class Solution {
    int deepest = -1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        traverse(root, 0);
        return sum;
    }
    
    private void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (level > deepest) {
            sum = root.val;
            deepest = level;
        }
        else if (level == deepest)
            sum += root.val;
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}
