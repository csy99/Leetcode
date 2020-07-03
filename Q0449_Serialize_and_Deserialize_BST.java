package Leetcode;

/**
 * Created by csy99 on 5/12/20.
 */
public class Q449_Serialize_and_Deserialize_BST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }
    
    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val).append(",");
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(",");
        return build(arr, 0, arr.length);
    }
    
    // exclude r
    private TreeNode build(String[] arr, int l, int r) {
        if (l >= r) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[l]));
        int pos = l + 1;
        for (; pos < r; pos++) {
            if (Integer.parseInt(arr[pos]) > root.val)
                break;
        }
        root.left = build(arr, l+1, pos);  // 1~pos-1
        root.right = build(arr, pos, r);
        return root;
    }
}
