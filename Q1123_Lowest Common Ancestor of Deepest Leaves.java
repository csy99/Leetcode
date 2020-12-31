/**
 * Created by csy99 on 12/30/20.
 */
class Solution {
    int deepest = 0;
    TreeNode res = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        traverse(root, 0);
        return res;
    }
    
    public int traverse(TreeNode cur, int d) {
        if (cur == null) 
            return d-1;
        int fromLeft = traverse(cur.left, d+1);
        int fromRight = traverse(cur.right, d+1);
        if (d > deepest)
            deepest = d;
        if (fromLeft == fromRight && fromLeft == deepest)
            res = cur;
        return Math.max(fromLeft, fromRight);
    }
}
