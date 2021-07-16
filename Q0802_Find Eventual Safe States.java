/**
 * Created by csy99 on 7/16/21.
 */
class Solution {
    Boolean[] safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        int n = graph.length;
        safe = new Boolean[n];
        for (int i = 0; i < n; i++)
            dfs(graph, i, new HashSet());
        for (int i = 0; i < n; i++)
            if (safe[i])
                res.add(i);
        return res;
    }
    
    private boolean dfs(int[][] graph, int cur, Set<Integer> seen) {
        if (safe[cur] != null)
            return safe[cur];
        if (seen.contains(cur)) {
            safe[cur] = false;
            return false;
        }
        seen.add(cur);
        for (int nxt: graph[cur]) {
            if (!dfs(graph, nxt, seen)) {
                safe[cur] = false;
                return false;
            }
        }
        return safe[cur] = true;
    }
}
