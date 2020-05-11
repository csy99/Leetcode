package Leetcode;

/**
 * Created by csy99 on 5/11/20.
 */
public class Q429_N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        List<Node> curLevel = new ArrayList();
        List<Node> nxtLevel = new ArrayList();
        List<Integer> elements = new ArrayList();
        curLevel.add(root);
        while (curLevel.size() > 0) {
            Node cur = curLevel.remove(0);
            nxtLevel.addAll(cur.children);
            elements.add(cur.val);
            if (curLevel.size() == 0) {
                res.add(elements);
                elements = new ArrayList();
                curLevel = nxtLevel;
                nxtLevel = new ArrayList();
            }
        }
        return res;
    }
}
