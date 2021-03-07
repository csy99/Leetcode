/**
 * Created by csy99 on 3/7/21.
 */
class Solution {
    List<long[]>[] graph;
    int kmod = (int)1e9+7;
    long res = 0;
    public int countRestrictedPaths(int n, int[][] edges) {
        graph = new List[n+1]; 
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList();
        for (int[] e: edges) {
            graph[e[0]].add(new long[]{e[1], e[2]});
            graph[e[1]].add(new long[]{e[0], e[2]});
        }
        long[] distToLast = dijkstra(n);
        return dfs(1, n, distToLast, new Integer[n+1]);
    }
    
    private long[] dijkstra(int n) {
        long[] distToLast = new long[n+1];
        for (int i = 0; i < n; i++)
            distToLast[i] = Integer.MAX_VALUE;
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a,b)->((int)(a[1]-b[1])));
        pq.add(new long[]{n,0});
        while (pq.size() > 0) {
            long[] top = pq.poll();
            int u = (int)top[0];
            int d = (int)top[1];
            if (d > distToLast[u])
                continue;
            for (long[] nei: graph[u]) {
                int v = (int)nei[0];
                int w = (int)nei[1];
                if (distToLast[v] > distToLast[u] + w) {
                    distToLast[v] = distToLast[u] + w;
                    pq.offer(new long[]{v, distToLast[v]});
                }
            }
        }
        return distToLast;
    }
    
    private int dfs(int cur, int n, long[] distToLast, Integer[] memo) {
        if (memo[cur] != null)
            return memo[cur];
        if (cur == n) 
            return 1;
        int ans = 0;
        for (long[] nei: graph[cur]) {
            int v = (int)nei[0];
            int w = (int)nei[1];
            if (distToLast[cur] <= distToLast[v]) 
                continue;
            ans = (ans+dfs(v, n, distToLast, memo)) % kmod;
        }
        return memo[cur] = ans;
    }
}
