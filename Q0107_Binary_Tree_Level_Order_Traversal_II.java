package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by csy99 on 4/5/20.
 */
public class Q107_Binary_Tree_Level_Order_Traversal_II {
    // reverse the result of Q102 is trivial
    int deepest = 0;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        deepest = maxDepth(root);
        for (int i = 0; i < deepest; i++)
            res.add(new ArrayList<Integer>());
        dfs(res, root, 1);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null)
            return;
        res.get(deepest - level).add(root.val);
        dfs(res, root.left, level+1);
        dfs(res, root.right, level+1);
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
