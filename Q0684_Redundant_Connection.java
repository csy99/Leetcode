/**
 * Created by csy99 on 4/12/20.
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 */
public class Q0684_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet s = new UnionFindSet(edges.length);
        for (int[] edge: edges) {
            if (!s.union(edge[0], edge[1]))
                return edge;
        }
        return null;
    }
    
    
    class UnionFindSet {
        private int[] parents;
        private int[] ranks;
        
        public UnionFindSet(int n) {
            parents = new int[n+1];
            ranks = new int[n+1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public int find(int u) {
            while (parents[u] != u) {
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
        
        /* Merge sets that contains u and v.
         * Return true if merged, false if u and v are already in one set.
         */
        public boolean union(int u, int v) {
            int ru = find(u);
            int rv = find(v);
            if (ru == rv) return false;
            
            // merge low height tree into high rank tree
            if (ranks[rv] > ranks[ru])
                parents[ru] = rv;
            else if (ranks[ru] > ranks[rv])
                parents[rv] = ru;
            else {
                parents[ru] = rv;
                ranks[rv]++;
            }
            return true;    
        }
    }
}
