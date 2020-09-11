package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.Stack;

/**
 * Created by csy99 on 4/6/20.
 */
public class Q173_Binary_Search_Tree_Iterator {
class BSTIterator {

    Stack<TreeNode> st = new Stack();
    
    private void findLeftMost(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }
    }
    
    public BSTIterator(TreeNode root) {
        findLeftMost(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        findLeftMost(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }
}
}
