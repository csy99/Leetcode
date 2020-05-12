/**
 * Created by csy99 on 5/12/20. 
 */
class Solution {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        findPath(root);
        return longest - 1;
    }
    
    private int findPath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            longest = Math.max(longest, 1);
            return 1;
        }
        int left = findPath(root.left);
        int right = findPath(root.right);
        int path = 0;  // use at most one child
        int cur = 1; // use both children 
        if (root.left != null && root.val == root.left.val) {
            cur += left;
            path += left;
        }
        if (root.right != null && root.val == root.right.val) {
            cur += right;
            path = Math.max(path, right);
        }
        longest = Math.max(longest, cur);
        return 1 + path;
    }
}
