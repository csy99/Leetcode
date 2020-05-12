/**
 * Created by csy99 on 5/12/20.
 */
class Solution {
    int res;
    HashSet<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        res = 0;
        covered = new HashSet();
        covered.add(null);
        dfs(root, null);
        return res;
    }
    
    private void dfs(TreeNode cur, TreeNode parent) {
        if (cur == null)
            return;
        dfs(cur.left, cur);
        dfs(cur.right, cur);
        if ((parent == null && !covered.contains(cur)) || 
          !covered.contains(cur.left) || !covered.contains(cur.right)) {
            res++;
            covered.add(cur);
            covered.add(parent);
            covered.add(cur.left);
            covered.add(cur.right);
        }
    }
}
