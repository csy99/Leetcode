package Leetcode;

/**
 * Created by csy99 on 9/9/20.
 */
public class Q426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> st = new Stack();
        TreeNode cur = root;
        TreeNode dummy = new TreeNode(0); // a reference pointing to the head
        TreeNode prev = null;
        
        while (st.size() > 0 || cur != null) {
            while (cur != null) {
               st.push(cur);
               cur = cur.left;
            }
            cur = st.pop();
            if (dummy.right == null)
                dummy.right = cur;
            // links predecessor and successor
            if (prev != null) {
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }
        // make the linked list circular
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
}
