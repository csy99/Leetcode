/**
 * Created by csy99 on 11/7/21.
 */
// full dfs, time: O(nd), space: O(d), d is depth 
class Solution {
    String res = "~";
    
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }
    
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append((char)(root.val + 'a'));
        if (root.left == null && root.right == null) {
            String cur = sb.reverse().toString();
            sb.reverse();
            if (cur.compareTo(res) < 0)
                res = cur;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
