/**
 * Created by csy99 on 9/20/21.
 */
class Solution {
    public int minimumCost(int n, int[][] connections) {
        int m = connections.length;
        Arrays.sort(connections, (a,b)->(a[2]-b[2]));
        int res = 0;
        UFS ufs = new UFS(n+1);
        for (int i = 0; i < m; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            int cost = connections[i][2];
            if (ufs.union(a,b)) continue;
            res += cost;
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++)
            cnt = Math.max(cnt, ufs.size[i]);
        if (cnt < n) return -1;
        return res;
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
    
    public boolean union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return true;
        if (size[ru] > size[rv]) {
            parent[rv] = ru;
            size[ru] += size[rv];
        } else {
            parent[ru] = rv;
            size[rv] += size[ru];
        }
        
        return false;
    }
}
