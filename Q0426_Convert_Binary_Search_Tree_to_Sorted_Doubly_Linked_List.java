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

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node[] nodes = helper(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];
        return nodes[0];
    }
    
    private Node[] helper(Node root) {
        if (root == null) return new Node[]{null, null};
        Node[] l = helper(root.left);
        Node[] r = helper(root.right);
        root.left = l[1];
        if (l[1] != null)
            l[1].right = root;
        root.right = r[0];
        if (r[0] != null)
            r[0].left = root;
        
        Node head = root;
        if (l[0] != null)
            head = l[0];
        Node tail = root;
        if (r[1] != null)
            tail = r[1];
        return new Node[] {head, tail};
    }
}
