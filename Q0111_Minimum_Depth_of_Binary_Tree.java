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
        if (root == null) 
            return 0;
        return traverse(root, 0);
    }
    
    private int traverse(TreeNode root, int depth) {
        if (root.left == null && root.right == null)
            return depth+1;
        else if (root.left == null)
            return traverse(root.right, depth)+1;
        else if (root.right == null)
            return traverse(root.left, depth)+1;
        int l = traverse(root.left, depth+1);
        int r = traverse(root.right, depth+1);
        return Math.min(l, r);
    }

    // iteration
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
