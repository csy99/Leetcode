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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> path = new ArrayList();
    if (root == null) return path;
    dfs(path, root, new StringBuilder());
    return path;
  }
  
  private void dfs(List<String> path, TreeNode root, StringBuilder cur) {
    cur.append(root.val);
    int len = cur.length();
    if (root.left == null && root.right == null) {  // check if it is a leaf
      path.add(cur.toString());
      return;
    }
    if (root.left != null) {
      dfs(path, root.left, cur.append("->"));
      cur.setLength(len);
    }
    if (root.right != null) {
      dfs(path, root.right, cur.append("->"));
      cur.setLength(len);
    }
  }
}
