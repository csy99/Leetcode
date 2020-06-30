/**
 * Created by csy99 on 5/11/20.
 */
class Solution {
    // recursive
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList();
        traverse(root, res);
        return res;
    }
    
    private void traverse(Node root, List<Integer> res) {
        if (root == null)
            return;
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++)
            traverse(children.get(i), res);
        res.add(root.val);
    }
    
    // iterative
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList();
        if (root == null) return res;
        Stack<Node> st = new Stack();
        st.push(root);
        while (st.size() > 0) {
            Node cur = st.pop();
            res.add(0, cur.val);
            List<Node> children = cur.children;
            for (Node child: children)
                st.push(child);
        }
        return res;
    }
}
