/**
 * Created by csy99 on 4/24/20.
 */
class Solution {
    public int numSimilarGroups(String[] A) {
        UFS ufs = new UFS(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                if (similar(A[i], A[j]))
                    ufs.union(i, j);
            }
        }
        return ufs.size;
    }
    
    private boolean similar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) 
                diff++;
            if (diff > 2)
                return false;
        }
        return true;
    }
}

class UFS {
    int size;
    int[] parent;
    int[] rank;
    public UFS(int n) {
        size = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int u) {
        while (u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    
    public void union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return;
        if (rank[ru] < rank[rv])
            parent[ru] = rv;
        else if (rank[rv] < rank[ru])
            parent[rv] = ru;
        else {
            parent[rv] = ru;
            rank[ru] ++;
        }
        size--;
    } 
}
