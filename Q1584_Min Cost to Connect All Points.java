/**
 * Created by csy99 on 9/12/20 during contest.
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 0;
        if (n == 2) return distance(points[0], points[1]);
        int[][] mat = new int[n][n];
        int res = 0;
        PriorityQueue<Entry> pq = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                mat[i][j] = distance(points[i], points[j]);
                Entry e = new Entry(i, j, mat[i][j]);
                pq.offer(e);
            }
        }
        
        UFS ufs = new UFS(n);
        while (true) {
            Entry e = pq.poll();
            int x = e.x;
            int y = e.y;
            int dist = e.dist;
            if (ufs.find(x) == ufs.find(y))
                continue;
            ufs.union(x, y);
            res += dist;
            int total = 0;
            for (int i = 1; i < n; i++) {
                if (ufs.find(i) != ufs.find(0))
                    break;
                total++;
            }
            if (total == n-1) break;
        }
        return res;
    }
    
    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}

class Entry implements Comparable<Entry> {
    int x;
    int y;
    int dist;
    public Entry(int a, int b, int d) {
        x = a;
        y = b;
        dist = d;
    }
    
    public int compareTo(Entry e2) {
        return Integer.compare(dist, e2.dist);
    }
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
