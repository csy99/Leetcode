/**
 * Created by csy99 on 5/11/20.
 * <p>
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and
 * node values with a subtree of s.
 * <p>
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class Q572_Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList();
        q.offer(s);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur.val == t.val && isSame(cur, t))
                return true;
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        return false;
    }
    
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
