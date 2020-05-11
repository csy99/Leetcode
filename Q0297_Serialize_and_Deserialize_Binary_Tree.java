package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/7/20.
 */
public class Q297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
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

    // Decodes your encoded data to tree.
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
}
}
