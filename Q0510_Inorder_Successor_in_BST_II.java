package Leetcode;

/**
 * Created by csy99 on 4/12/21.
 */
public class Q510_Inorder_Successor_in_BST_II {
    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            node = node.right;
            while (node.left != null) 
                node = node.left;
            return node;
        }
        while (node.parent != null && node == node.parent.right)
            node = node.parent;
        return node.parent;
    }
}
