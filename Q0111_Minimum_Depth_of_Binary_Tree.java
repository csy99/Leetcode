package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/4/20.
 */
public class Q111_Minimum_Depth_of_Binary_Tree {
    // recusion
    public int minDepth(TreeNode root) {
        return depth(root, 0);
    }
    
    private int depth(TreeNode root, int d) {
        if (root == null)
            return d;
        if (root.left == null && root.right == null)
            return 1 + d;
        if (root.right == null)
            return 1 + depth(root.left, d);
        else if (root.left == null)
            return 1 + depth(root.right, d);
        return 1 + Math.min(depth(root.left, d), depth(root.right, d));
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int min = 0;
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            min++;

            for (int i = 0; i < sizeOfQueue; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return min;
                else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }
        return min;
    }
}
