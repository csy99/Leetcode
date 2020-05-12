package Leetcode;

import Leetcode.Util.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 4/1/20.
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Q257_Binary_Tree_Paths {
    List<String> res = new ArrayList();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        int len = sb.length();
        sb.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            String path = new String(sb).substring(2);
            res.add(path);
            sb.setLength(len);
            return;
        }
        if (root.left != null)
            dfs(root.left, sb);
        if (root.right != null)
            dfs(root.right, sb);
        sb.setLength(len);
    }
}
