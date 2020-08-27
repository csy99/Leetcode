package Leetcode;

/**
 * Created by csy99 on 8/27/20.
 */
public class Q417_Pacific_Atlantic_Water_Flow {
    int m;
    int n;
    int[] dirs = new int[]{-1, 0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList();
        m = matrix.length;
        if (m == 0) return res;
        n = matrix[0].length;
        if (n == 0) return res;
        boolean[][] reachP = new boolean[m][n];
        boolean[][] reachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {  
            dfs(matrix, i, 0, 0, reachP);  // left
            dfs(matrix, i, n-1, 0, reachA);  // right
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, 0, reachP); // top
            dfs(matrix, m-1, j, 0, reachA); // bot
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (reachP[i][j] && reachA[i][j]) {
                    List<Integer> coord = new ArrayList();
                    coord.add(i);
                    coord.add(j);
                    res.add(coord);
                }
        return res;
    }
    
    private void dfs(int[][] matrix, int y, int x, int h, boolean[][] reach) {
        if (y < 0 || x < 0 || y >= m || x >= n || matrix[y][x] < h)
            return;
        if (reach[y][x])
            return;
        reach[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int ny = y + dirs[d];
            int nx = x + dirs[d+1]; 
            dfs(matrix, ny, nx, matrix[y][x], reach);
        }
    }
}
