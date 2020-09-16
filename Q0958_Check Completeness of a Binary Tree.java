/**
 * Created by csy99 on 9/15/20.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        boolean seeNull = false;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur == null)
                seeNull = true;
            else {
                if (seeNull) return false;
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return true;
    }
}
