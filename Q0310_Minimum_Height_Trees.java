package Leetcode;

/**
 * Created by csy99 on 4/11/20.
 */
public class Q310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        List<Integer> leaf = new ArrayList();
        if (n == 1) {
            leaf.add(0);
            return leaf;
        }
        HashMap<Integer, HashSet<Integer>> g = new HashMap();
        // build graph
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            degree[a]++;
            degree[b]++;
            
            HashSet<Integer> neighbor = null;
            if (!g.containsKey(a))
                neighbor = new HashSet();
            else
                neighbor = g.get(a);
            neighbor.add(b);
            g.put(a, neighbor);
            
            if (!g.containsKey(b)) 
                neighbor = new HashSet();
            else 
                neighbor = g.get(b);
            neighbor.add(a);
            g.put(b, neighbor);
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                leaf.add(i);
        }
        // prune the tree from outside inwards
        List<Integer> newLeaf = new ArrayList();
        while (n > 2) {
            n -= leaf.size();
            int m = leaf.size();
            for (int j = 0; j < m; j++) {
                int cur = leaf.remove(0);
                degree[cur] = 0;
                HashSet<Integer> neighbors = g.get(cur);
                for (int nei: neighbors) {
                    degree[nei]--;
                    g.get(nei).remove(cur);
                    if (degree[nei] == 1)
                        newLeaf.add(nei);
                }
            }
            leaf = newLeaf;
            newLeaf = new ArrayList();
        }
        return leaf;
    }
}
