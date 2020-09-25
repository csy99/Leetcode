/**
 * Created by csy99 on 9/24/20.
 */
// 有一种暴力解法是将整棵树转化成无向图做BFS，会有一些不必要的工作。
// 下面这种解法充分利用二叉树的层次特点
class Solution {
    List<Integer> res = new ArrayList();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null) return res;
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        getDist(root, target, K);
        return res;
    }
    
    // Returns the distance from root to target.
    // Returns -1 if target does not in the tree.
    private int getDist(TreeNode root, TreeNode target, int K) {
        if (root == null)
            return -1;
        if (root == target) {
            helper(target, K);
            return 0;
        }
        int l = getDist(root.left, target, K);
        int r = getDist(root.right, target, K);
        if (l >= 0) {
            if (l == K - 1)
                res.add(root.val);
            helper(root.right, K-l-2);
            return l + 1;
        }
        if (r >= 0) {
            if (r == K - 1)
                res.add(root.val);
            helper(root.left, K-r-2);
            return r + 1;
        }
        return -1;
    }
    
    private void helper(TreeNode root, int d) {
        if (root == null || d < 0)
            return;
        if (d == 0) {
            res.add(root.val);
            return;
        }
        helper(root.left, d-1);
        helper(root.right, d-1);
    }
}
