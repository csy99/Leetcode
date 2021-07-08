/**
 * Created by csy99 on 7/8/21.
 */
class Solution {
    int n;
    int[][] dist;
    int[][] edges;
    final int INF = Integer.MAX_VALUE - (int)1e4;
    
    public int findTheCity(int n, int[][] edges, int threshold) {
        this.n = n;
        dist = new int[n][n];
        this.edges = edges;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                dist[i][j] = INF;
            }
        for (int[] edge: edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i++)
            helper(i);
        
        int size = n;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (dist[i][j] <= threshold)
                    s++;
            }
            if (s <= size) {
                size = s;
                idx = i;
            }
        }
        return idx;
        
    }
    
    // calculate the shortest distance to each node from the src node
    private void helper(int src) {
        for (int c = 0; c < n; c++) {
            for (int[] edge: edges) {
                int a = edge[0];
                int b = edge[1];
                int w = edge[2];
                dist[src][b] = Math.min(dist[src][b], dist[src][a] + w);
                dist[src][a] = Math.min(dist[src][a], dist[src][b] + w);
            }
        }
    }
    
}
