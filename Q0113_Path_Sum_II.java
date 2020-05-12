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
        helper(root, sum, new ArrayList());
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        int len = path.size();
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList(path));
            path.remove(len-1);
            return;
        }
        helper(root.left, sum-root.val, path);
        helper(root.right, sum-root.val, path);
        path.remove(len-1);
    }
}
