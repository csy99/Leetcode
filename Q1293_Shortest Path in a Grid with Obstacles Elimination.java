/**
 * Created by csy99 on 10/8/21.
 */
class Solution {
    public int shortestPath(int[][] grid, int K) {
        int[] dirs = new int[]{-1,0,1,0,-1};
        int m = grid.length;
        int n = grid[0].length;
        final int INF = m*n+1;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = INF;
        dist[0][0] = 0;
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {0,0,0});
        int step = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] coord = q.poll();
                int y = coord[0];
                int x = coord[1];
                int cost = coord[2];
                if (y == m-1 && x == n-1) return step;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dirs[d];
                    int nx = x + dirs[d+1];
                    int ncost = cost + grid[y][x];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                        continue;
                    if (ncost >= dist[ny][nx] || ncost > K)
                        continue;
                    dist[ny][nx] = ncost;
                    q.add(new int[]{ny, nx, ncost});
                }
            }
            step++;
        }   
        return -1;
    }
}
