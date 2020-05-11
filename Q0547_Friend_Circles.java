package Leetcode;

/**
 * Created by csy99 on 4/12/20.
 */
public class Q547_Friend_Circles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UFS ufs = new UFS(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1)
                    ufs.union(i, j);
            }
        }
        HashSet<Integer> circle = new HashSet();
        for (int i = 0; i < n; i++)
            circle.add(ufs.find(i));
        return circle.size();
    }
    
    class UFS {
        int[] parents;
        int[] ranks;
        
        public UFS(int n) {
            parents = new int[n+1];
            ranks = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }
        
        public int find(int u) {
            while (u != parents[u]) {
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
        
        public boolean union(int u, int v) {
            int ru = find(u);
            int rv = find(v);
            if (ru == rv) return false;
            
            if (ranks[ru] > ranks[rv])
                parents[rv] = ru;
            else if (ranks[rv] > ranks[ru])
                parents[ru] = rv;
            else {
                parents[ru] = rv;
                ranks[rv] += 1;
            } 
            return true;    
        }
    }
}
