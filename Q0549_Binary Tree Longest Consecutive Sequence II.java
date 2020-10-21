/**
 * Created by csy99 on 10/20/20.
 *
 * Given a binary tree, find the length(number of nodes) of the longest consecutive sequence(Monotonic and adjacent node values differ by 1) path.
 * The path could be start and end at any node in the tree.
 */
public class Solution {
    int longest = 0;
    public int longestConsecutive2(TreeNode root) {
        postorder(root);
        return longest;
    }
    
    // [0]: length of increasing series; [1]: length of decreasing series
    private int[] postorder(TreeNode root) {
        if (root == null) 
            return new int[] {0,0};
        int[] left = postorder(root.left);
        int[] right = postorder(root.right);
        if (root.left != null && root.left.val == root.val + 1)
            left[0]++;
        else
            left[0] = 1;
        if (root.left != null && root.left.val == root.val - 1)
            left[1]++;
        else
            left[1] = 1;
        if (root.right != null && root.right.val == root.val + 1)
            right[0]++;
        else
            right[0] = 1;
        if (root.right != null && root.right.val == root.val - 1)
            right[1]++;
        else
            right[1] = 1;
        longest = Math.max(longest, 
            Math.max(left[1]+right[0], left[0]+right[1])-1);  //重复计算了root
        return new int[]{Math.max(left[0], right[0]), Math.max(left[1], right[1])};
    }
}
