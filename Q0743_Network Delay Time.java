/** 
 * Created by csy99 on 7/7/21.
 */

// Bellman, time: O(V*E), space: O(V)
class Solution {
    public int networkDelayTime(int[][] times, int n, int s) {
        int inf = 101*100;
        int[] dist = new int[n+1];
        for (int i = 1; i <= n; i++)
            dist[i] = inf;
        dist[s] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] e: times)
                dist[e[1]] = Math.min(dist[e[1]], dist[e[0]] + e[2]); 
        }
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, dist[i]);
        if (res == inf) return -1;
        return res;
    }
}

// Dijkstra, time: O(E*log V), space:O(V^2)
class Solution {
    public int networkDelayTime(int[][] times, int n, int s) {
        final int INF = 100*101;
        Integer[][] weights = new Integer[n+1][n+1];
        for (int[] edge: times) 
            weights[edge[0]][edge[1]] = edge[2];
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->(a.dist-b.dist));
        pq.offer(new Node(s, 0));
        int[] delay = new int[n+1];
        for (int i = 1; i <= n; i++)
            delay[i] = INF;
        while (pq.size() > 0) {
            Node cur = pq.poll();
            delay[cur.idx] = Math.min(delay[cur.idx], cur.dist);
            for (int j = 1; j <= n; j++) {
                if (j == s) continue;
                if (weights[cur.idx][j] == null) continue;
                int d = cur.dist + weights[cur.idx][j];
                if (d < delay[j])
                    pq.add(new Node(j, d));
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = Math.max(res, delay[i]);
        if (res >= INF) return -1;
        return res;
    }
    
}

class Node {
    int idx;
    int dist;
    
    public Node(int i, int d) {
        idx = i;
        dist = d;
    }
}
