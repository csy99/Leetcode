// dfs
// time: O(n), space: O(n)
class Solution {
    int n;
    boolean[] seen;
    List<Edge>[] graph;
    int res = Integer.MAX_VALUE;
    
    public int minScore(int n, int[][] roads) {
        this.n = n;
        seen = new boolean[n+1];
        graph = new List[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList();

        for (int[] road: roads) {
            int a = road[0];
            int b = road[1];
            graph[a].add(new Edge(a, b, road[2]));
            graph[b].add(new Edge(b, a, road[2]));
        }
        
        return dfs(1);
        // return res;
    }
    
    private int dfs(int cur) {
        if (seen[cur]) return Integer.MAX_VALUE;
        seen[cur] = true;
        List<Edge> neighs = graph[cur];
        int min_on_path = Integer.MAX_VALUE;
        for (Edge edge: neighs) {
            min_on_path = Math.min(min_on_path, Math.min(edge.dist, dfs(edge.to)));
        }
        return min_on_path;
    }
}

class Edge {
    int from;
    int to;
    int dist;
    
    public Edge(int f, int t, int d) {
        from = f;
        to = t;
        dist = d;
    }
}
