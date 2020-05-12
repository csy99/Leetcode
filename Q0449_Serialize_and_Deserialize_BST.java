package Leetcode;

/**
 * Created by csy99 on 5/12/20.
 */
public class Q449_Serialize_and_Deserialize_BST {
    // preorder
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    
    private void write(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val).append(" ");
        write(root.left, sb);
        write(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] arr = data.split("\\s");
        int[] pos = new int[1];  // need to be remembered
        return build(arr, pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode build(String[] arr, int[] pos, int treeMin, int treeMax) {
        if (pos[0] >= arr.length)
            return null;
        int v = Integer.parseInt(arr[pos[0]]);
        if (v < treeMin || v > treeMax)
            return null;
        TreeNode cur = new TreeNode(v);
        pos[0]++;
        cur.left = build(arr, pos, treeMin, v);
        cur.right = build(arr, pos, v, treeMax);
        return cur;
    }
}
