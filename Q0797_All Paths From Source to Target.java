/**
 * Created by csy99 on 9/25/21.
 */
class Solution {
    int[][] graph;
    List<List<Integer>> res = new ArrayList();
    int n = 0;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        dfs(0, new ArrayList());
        return res;
    }
    private void dfs(int cur, List<Integer> path) {
        path.add(cur);
        if (cur == n-1) {
            res.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        for (int nei: graph[cur]) 
            dfs(nei, path);
        path.remove(path.size()-1);
    }
}
