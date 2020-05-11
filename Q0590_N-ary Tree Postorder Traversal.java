/**
 * Created by csy99 on 5/11/20.
 */
class Solution {
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
