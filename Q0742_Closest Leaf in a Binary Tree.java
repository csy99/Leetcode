/**
 * Created by csy99 on 9/25/20.
 *
 Given a binary tree where every node has a unique value, and a target key k. Find the value of the closest leaf node
 to target k in the tree. 
 Here, closest to a leaf means that the least number of edges travelled on the binary tree to reach any leaf of the 
 tree. 
 */
public class Solution {
    HashMap<TreeNode, List<TreeNode>> graph;
    TreeNode start;
    public int findClosestLeaf(TreeNode root, int k) {
        graph = new HashMap();
        start = null;
        buildGraph(root, null, k);
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        HashSet<TreeNode> seen = new HashSet();
        while (q.size() > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                TreeNode cur = q.poll();
                seen.add(cur);
                if (cur.left == null && cur.right == null) 
                    return cur.val;
                for (TreeNode nei: graph.get(cur)) {
                    if (!seen.contains(nei))
                        q.add(nei);
                }
            }
        }        
        return 0;
    }
    
    
    private void buildGraph(TreeNode node, TreeNode parent, int k) {
        if (node == null)
            return;
        if (node.val == k)
            start = node;
        if (parent != null) {
            List<TreeNode> parentNei = graph.getOrDefault(parent, new ArrayList());
            parentNei.add(node);
            graph.put(parent, parentNei);
            List<TreeNode> curNei = graph.getOrDefault(node, new ArrayList());
            curNei.add(parent);
            graph.put(node, curNei);
        }
        buildGraph(node.left, node, k);
        buildGraph(node.right, node, k);
    }
}
