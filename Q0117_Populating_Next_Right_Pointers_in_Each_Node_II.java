package Leetcode;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public Node connect(Node root) {
        if (root == null) return null;
        Node first = root;
        Node nxtFirst = null;
        while (first != null) {
            Node cur = first;
            while (cur != null) {
                if (cur.left != null) {
                    if (nxtFirst == null)
                        nxtFirst = cur.left;
                    cur.left.next = findNext(cur, true);
                }
                if (cur.right != null) {
                    if (nxtFirst == null)
                        nxtFirst = cur.right;
                    cur.right.next = findNext(cur, false);
                }                    
                cur = cur.next;
            }
            first = nxtFirst;
            nxtFirst = null;
        }
        return root;
    }
    
    private Node findNext(Node root, boolean leftChild) {
        if (root == null) return null;
        if (leftChild && root.right != null)
            return root.right;
        Node cur = root.next;
        while (cur != null) {
            if (cur.left != null) return cur.left;
            if (cur.right != null) return cur.right;
            cur = cur.next;
        }
        return null;
    }
}

