/**
 * Created by csy99 on 11/15/22.
 */
// dfs
// time: O(n), space: O(n)
class Solution {
    int n;
    List[] graph;
    int[] amount;
        
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        n = amount.length;
        graph = new List[n];
        this.amount = amount;
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList();
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] seen = new boolean[n];
        
        return dfs(0, bob, 0, seen)[0];
    }
    
    private int[] dfs(
        int i,
        int bob,
        int d_a,
        boolean[] seen
    ) {
        seen[i] = true;
        int score = Integer.MIN_VALUE;
        int d_b = 0;
        if (i != bob)
            d_b = n;
        for (int nei: (ArrayList<Integer>)graph[i]) {
            if (seen[nei]) continue;
            int[] res = dfs(nei, bob, d_a+1, seen);
            score = Math.max(score, res[0]);
            d_b = Math.min(d_b, res[1]);
        }
        if (score == Integer.MIN_VALUE)  // A leaf node.
            score = 0;
        if (d_a == d_b) 
            score += amount[i] / 2;
        if (d_a < d_b)
            score += amount[i];
        return new int[] {score, d_b+1};
    }
}
