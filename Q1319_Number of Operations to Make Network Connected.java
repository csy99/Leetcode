/**
 * Created by csy99 on 9/26/21.
 */
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m < n-1) return -1;
        UFS ufs = new UFS(n);
        for (int i = 0; i < m; i++)
            ufs.union(connections[i][0], connections[i][1]);
        Set<Integer> seen = new HashSet();
        int res = n;
        for (int i = 0; i < n; i++) {
            int r = ufs.find(i);
            if (seen.contains(r)) continue;
            seen.add(r);
            res -= ufs.size[r]-1;
        }
        return res-1;
    }
}

class UFS {
    int[] parent;
    int[] size;
    
    public UFS(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int find(int u) {
        while (parent[u] != u) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    
    public void union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return;
        if (size[ru] <= size[rv]) {
            parent[ru] = rv;
            size[rv] += size[ru];
        } else {
            parent[rv] = ru;
            size[ru] += size[rv];
        }
    }
    
}
