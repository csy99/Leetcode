package Leetcode;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {
    public Node connect(Node root) {
        if (root == null) return null;
        Node nextLevelFirst = null;
        Node pre = null;
        Node cur = root;
        
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (nextLevelFirst == null) {
                        nextLevelFirst = cur.left;
                        pre = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (nextLevelFirst == null) {
                        nextLevelFirst = cur.right;
                        pre = cur.right;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            cur = nextLevelFirst;
            pre = null;
            nextLevelFirst = null;
        }
        return root;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
