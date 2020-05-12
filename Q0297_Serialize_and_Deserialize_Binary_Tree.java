package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/7/20.
 */
public class Q297_Serialize_and_Deserialize_Binary_Tree {
    // level order
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        sb.setLength(sb.length()-1); // remove last ","
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] tree = data.split(",");
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        q.offer(root);
        int i = 1;
        while (i < tree.length) {
            TreeNode parent = q.poll();
            if (!tree[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(tree[i]));
                parent.left = left;
                q.offer(left);
            }
            i++;
            if (!tree[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(tree[i]));
                parent.right = right;
                q.offer(right);                
            }
            i++;
        }
        return root;
    }
    
    // preorder
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    
    private void write(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        write(root.left, sb);
        write(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        String[] arr = data.split(",");
        LinkedList<String> nodes = new LinkedList();
        for (int i = 0; i < arr.length; i++)
            nodes.add(arr[i]);
        return build(nodes);
    }
    
    private TreeNode build(LinkedList<String> nodes) {
        String val = nodes.remove();
        if (val.equals("#")) 
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }
}
