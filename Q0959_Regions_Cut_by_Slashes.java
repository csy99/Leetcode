/**
 * Created by csy99 on 4/24/20.
 */
class Solution {
    // split a grid cell into four triangles, and encode them clockwisely from the top one as 0 to the left one as 3 
    public int regionsBySlashes(String[] grid) {
        UFS ufs = new UFS(4*grid.length*grid.length);
        for (int i = 0; i < grid.length; i++) {  // union triangles
            for (int j = 0; j < grid.length; j++) {
                int idx = 4 * (i * grid.length + j);  // the start index of triangles in the current grid cell;
                switch (grid[i].charAt(j)) {  // union triangles within one cell
                    case '/':
                        ufs.union(idx+0, idx+3);
                        ufs.union(idx+1, idx+2);
                        break;
                    case '\\':
                        ufs.union(idx+0, idx+1);
                        ufs.union(idx+2, idx+3);
                        break;
                    case ' ':  // union all in the cell
                        ufs.union(idx+0, idx+1);
                        ufs.union(idx+1, idx+2);
                        ufs.union(idx+2, idx+3);
                        break;
                    default:
                        break;
                }
            // union triangles across cells
            if (i < grid.length-1)
                ufs.union(idx + 2, idx + grid.length * 4);
            if (j < grid.length-1)
                ufs.union(idx + 1, (idx + 4) + 3);
            }
        }
        int cnt = 0; 
        for (int i = 0; i < 4*grid.length*grid.length; i++) {
            if (ufs.find(i) == i)  // a new component
                cnt++;
        }
        return cnt;
    }
}

class UFS {
    int[] parent;
    int[] rank;
    public UFS(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }
    
    public boolean union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return false;
        if (rank[ru] < rank[rv])
            parent[ru] = rv;
        else if (rank[rv] < rank[ru])
            parent[rv] = ru;
        else {
            parent[rv] = ru;
            rank[ru]++;
        }
        return true;
    }
    
    public int find(int u) {
        while (u != parent[u]) {
            parent[u] = parent[parent[u]];
            u = parent[u];
        }
        return u;
    }
    
}
