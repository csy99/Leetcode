/***
 * Created by csy99 on 5/11/20.
 */
class Solution {
    List<Integer> res;
    public List<Integer> preorder(Node root) {
        res = new ArrayList();
        if (root == null)
            return res;
        traversal(root);
        return res;
    }
    
    private void traversal(Node root) {
        if (root == null) return;
        res.add(root.val);
        List<Node> c = root.children;
        for (int i = 0; i < c.size(); i++) {
            traversal(c.get(i));
        }
    }
}
