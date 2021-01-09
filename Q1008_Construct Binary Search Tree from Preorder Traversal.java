/**
 * Created by csy99 on 1/8/2021.
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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;
        return construct(n, preorder, 0, n-1);
    }
    
    private TreeNode construct(int n, int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int cut = end+1;
        for (int i = start+1; i <= end; i++) {
            if (preorder[i] > root.val) {
                cut = i;
                break;
            }
        }
        root.left = construct(n, preorder, start+1, cut-1);
        root.right = construct(n, preorder, cut, end);
        return root;
    }
}
