/**
 * Created by csy99 on 7/7/21.
 */
// Dijkastra, time: O(ElogN), space: O(E).
class Solution {
    public int reachableNodes(int[][] edges, int M, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap();
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            Map<Integer, Integer> map = graph.getOrDefault(u, new HashMap());
            map.put(v, w);
            graph.put(u, map);
            map = graph.getOrDefault(v, new HashMap());
            map.put(u, w);
            graph.put(v, map);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->(a.dist-b.dist));
        pq.offer(new Node(0,0));
        Map<Integer, Integer> distance = new HashMap();
        distance.put(0,0);
        // [We use the encoding (u, v) = u * N + v.]
        Map<Integer, Integer> used = new HashMap();
        int res = 0;
        
        while (pq.size() > 0) {
            Node cur = pq.poll();
            if (cur.dist > distance.getOrDefault(cur.idx, 0))
                continue;
            res++;  // reach a node in the original graph
            if (!graph.containsKey(cur.idx)) continue;
            Map<Integer, Integer> map = graph.get(cur.idx);
            for (int nei: map.keySet()) {
                int weight = map.get(nei);
                // M - cur.dist is how much further we can walk from cur
                int utility = Math.min(weight, M-cur.dist);
                used.put(n*cur.idx+nei, utility);
                // total distance to reach nei
                int d2 = cur.dist+weight+1;
                if (d2 < distance.getOrDefault(nei, M+1)) {
                    pq.offer(new Node(nei, d2));
                    distance.put(nei, d2);
                }
            }
        }
        for (int[] edge: edges) {
            res += Math.min(edge[2], used.getOrDefault(edge[0]*n+edge[1], 0) + used.getOrDefault(edge[1]*n+edge[0], 0));
        }
        return res;
    }
}

class Node {
    int idx;
    int dist;
    public Node (int i, int d) {
        idx = i;
        dist = d;
    }
}
