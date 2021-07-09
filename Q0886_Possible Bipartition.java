/**
 * Created by csy99 on7/9/21.
 */
class Solution {
    int n;
    boolean[][] edges;
    int[] color;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.n = n;
        edges = new boolean[n+1][n+1];
        for (int[] e: dislikes) {
            edges[e[0]][e[1]] = true;
            edges[e[1]][e[0]] = true;
        }
        color = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(1, i))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int c, int idx) {
        if (color[idx] != 0)
            return color[idx] == c;
        color[idx] = c;
        for (int i = 1; i <= n; i++) {
            if (edges[idx][i] && !dfs(-c, i)) 
                return false;
        }
        return true;
    }
} 
