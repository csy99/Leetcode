/**
 * Created by csy99 on 7/9/21.
 */
class Solution {
    int n;
    int[][] graph;
    int[] res;
    public int[] gardenNoAdj(int n, int[][] paths) {
        this.n = n;
        graph = new int[n+1][3];
        res = new int[n];
        for (int[] path: paths) {
            int a = path[0];
            int b = path[1];
            for (int j = 0; j < 3; j++) {
                if (graph[a][j] == 0) {
                    graph[a][j] = b;
                    break;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (graph[b][j] == 0) {
                    graph[b][j] = a;
                    break;
                }
            }    
        }
        dfs(1);
        return res;
    }
    
    private boolean dfs(int idx) {
        if (idx > n) return true;
        for (int c = 1; c <= 4; c++) {
            if (isValid(idx, c)) {
                res[idx-1] = c;
                if (dfs(idx+1))
                    return true;
                res[idx-1] = 0;
            }
        }
        return false;
    }
    
    private boolean isValid(int u, int c) {
        for (int v: graph[u]) {
            if (v == 0) continue;
            if (c == res[v-1])
                return false;
        }
        return true;
    }
}
