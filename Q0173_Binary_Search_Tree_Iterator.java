package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q173_Binary_Search_Tree_Iterator {
class BSTIterator {
    Stack<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        st = new Stack();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        TreeNode runner = cur.right;
        while (runner != null) {
            st.push(runner);
            runner = runner.left;
        }
        return cur.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
}
