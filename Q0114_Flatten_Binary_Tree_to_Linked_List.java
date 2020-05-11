package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            if (cur.right != null) 
                st.push(cur.right);
            if (cur.left != null) 
                st.push(cur.left);
            if (!st.isEmpty())
                cur.right = st.peek();
            cur.left = null;
        }
    }
}
