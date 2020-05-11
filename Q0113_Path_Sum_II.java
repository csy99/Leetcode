package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/1/20.
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class Q113_Path_Sum_II {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) return res;   
    List<Integer> path = new ArrayList();
    path.add(root.val);
    dfs(root, sum, path);
    return res;
  }
  
  private void dfs(TreeNode root, int sum, List<Integer> path) {
    if (root.left == null && root.right == null && sum == root.val) {
      res.add(new ArrayList(path));
      return;
    }
    
    if (root.left != null) {
      path.add(root.left.val);
      dfs(root.left, sum-root.val, path);
      path.remove(path.size()-1);
    }
    
    if (root.right != null) {
      path.add(root.right.val);
      dfs(root.right, sum-root.val, path);
      path.remove(path.size()-1);
    }
  }
}
