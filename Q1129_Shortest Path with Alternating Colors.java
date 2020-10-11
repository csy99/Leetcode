/**
 * Created by csy99 on 10/10/20.
 */
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[] edges_r = new HashSet[n];
        Set<Integer>[] edges_b = new HashSet[n];
        for (int[] e: red_edges) {
            if (edges_r[e[0]] == null)
                edges_r[e[0]] = new HashSet<Integer>();
            edges_r[e[0]].add(e[1]);
        }
        for (int[] e: blue_edges) {
            if (edges_b[e[0]] == null)
                edges_b[e[0]] = new HashSet<Integer>();
            edges_b[e[0]].add(e[1]);
        }
        Set<Integer> seen_r = new HashSet();
        Set<Integer> seen_b = new HashSet();
        Queue<Edge> q = new LinkedList();
        q.add(new Edge(0,0));
        q.add(new Edge(0,1));
        seen_r.add(0);
        seen_b.add(0);
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = -1;
        int step = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Edge cur = q.poll();
                int node = cur.node;
                int col = cur.color;
                if (res[node] == -1)
                    res[node] = step;
                else
                    res[node] = Math.min(res[node], step);
                Set<Integer>[] edges = col == 0 ? edges_r : edges_b;
                Set<Integer> seen = col == 0 ? seen_r : seen_b;
                if (edges[node] == null) continue;
                for (int nxt: edges[node]) {
                    if (seen.contains(nxt))
                        continue;
                    seen.add(nxt);
                    q.add(new Edge(nxt, 1 - col));
                }
            }
            step++;
        }
        return res;
    }
}

class Edge {
    int node;
    int color;  // 0 is red, 1 is blue
    
    public Edge(int i, int c) {
        node = i;
        color = c;
    }
}
