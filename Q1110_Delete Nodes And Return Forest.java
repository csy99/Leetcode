/**
 * Created by csy99 on 10/4/21.
 */
class Solution {
    List<TreeNode> res = new ArrayList();
    Set<Integer> dict = new HashSet();
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int t_d: to_delete)
            dict.add(t_d);
        dfs(root, null, false);
        return res;
    }
    
    private void dfs(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (dict.contains(root.val)) {
            if (parent != null) {
                if (isLeft)
                    parent.left = null;
                else
                    parent.right = null;
            }
            root.left = null;
            root.right = null;
            root = null;
        } else {
            if (parent == null)
                res.add(root);
        }
        dfs(left, root, true);
        dfs(right, root, false);
    }
}
