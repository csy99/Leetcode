/**
 * Created by csy99 on 7/5/21.
 */
class Solution {
    List<List<Integer>> res = new ArrayList();
    int n;
    List<Integer>[] neighbors;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        neighbors = new List[n];
        for (List<Integer> edge: connections) {
            int a = edge.get(0);
            int b = edge.get(1);
            if (neighbors[a] == null) 
                neighbors[a] = new ArrayList();
            neighbors[a].add(b);
            if (neighbors[b] == null) 
                neighbors[b] = new ArrayList();
            neighbors[b].add(a);
        }
        int[] path = new int[n];
        for (int i = 0; i < n; i++)
            path[i] = -1;
        dfs(0, -1, 0, path);
        return res;
    }
    
    private int dfs(int cur, int par, int d, int[] path) {
        path[cur] = d + 1;
        for (int child: neighbors[cur]) {
            if (child == par) continue;
            if (path[child] == -1) { // unvisited child
                path[cur] = Math.min(path[cur], dfs(child, cur, d+1, path));
            } else { // visited child
                path[cur] = Math.min(path[cur], path[child]);
            }
        }
        if (path[cur] > d && par != -1) { // current edge not on a circle
            List<Integer> edge = new ArrayList();
            edge.add(cur);
            edge.add(par);
            res.add(edge);
        }
        return path[cur];
    }
}
