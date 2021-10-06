/**
 * Created by csy99 on 10/5/21.
 */
class CBTInserter {
    TreeNode root;
    boolean isLeft;
    Queue<TreeNode> q;
    
    public CBTInserter(TreeNode root) {
        this.root = root;    
        isLeft = true;
        q = new LinkedList();
        q.add(root);
        while (q.size() > 0) {
            TreeNode cur = q.peek();
            if (cur.left == null) 
                break;
            q.add(cur.left);
            if (cur.right == null) {
                isLeft = false;
                break;
            }
            q.add(cur.right);
            q.poll();
        }
    }
    
    public int insert(int val) {
        TreeNode cur = new TreeNode(val);
        TreeNode par = null;
        if (isLeft) {
            par = q.peek();
            par.left = cur;
        } else {
            par = q.poll();
            par.right = cur;
        }
        isLeft = !isLeft; 
        q.add(cur);
        return par.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}
