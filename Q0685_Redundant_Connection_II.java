/**
 * Created by csy99 on 4/24/20. 
 *
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 *
 *The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 */
class Solution {
    // case 1: no node has dup parents, but a circle exists, same to previous problem, 
    //      delete the first edge that creates the loop
    // case 2: one node has dup parents, but no circle exists (only one root), 
    //      delete the edge that creates dup parents
    // case 3: one node has dup parents, and a circle exists, 
    //      delete the edge that creates the circle
    //      (the "to node" must be the node that has dup parents)
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] res1 = null;
        int[] res2 = null;
        // find out if dup parents
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            // this node has dup parents
            if (parent[v] > 0) {
                res1 = new int[] {parent[v], v};
                res2 = new int[] {u, v};
                // delete the later edge, hopefully this eliminates the loop
                edges[i][1] = -1;
            } else
                parent[v] = u;
        }
        // start UFS again
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        // check circle
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            // invalid edge (delete above)
            if (v < 0) continue;
            // check if there is circle
            if (find(u, parent) == v) {
                // check dup parents
                if (res1 == null)
                    return edges[i];  // case 1
                else
                    return res1;  // case 3
            }
            // union
            parent[v] = u;
        }
        return res2;  // case 2
    }
    
    private int find(int node, int[] root) {
        while (node != root[node]) {
            root[node] = root[root[node]];
            node = root[node];
        }
        return node;
    }
}
