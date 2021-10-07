/**
 * Created by csy99 on 10/6/21.
 */
// time: O(n^2) because of string concat, space: O(n)
class Solution {
    Map<String, Integer> counts = new HashMap();
    List<TreeNode> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private String dfs(TreeNode root) {
        if (root == null) return "N";
        String left = dfs(root.left);
        String right = dfs(root.right);
        sb.setLength(0);
        sb.append(left).append(",").append(right).append(",").append(root.val);
        String key = sb.toString();
        int cnt = counts.getOrDefault(key, 0) + 1;
        if (cnt == 2) res.add(root);
        counts.put(key, cnt);
        return key;
    }
}
