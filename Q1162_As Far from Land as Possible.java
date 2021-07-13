/**
 * Created by csy99 on 7/13/21.
 */
class Solution {

    int[] dirs = new int[] {-1,0,1,0,-1};
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];
        int step = 0;
        Queue<Integer> qy = new LinkedList();
        Queue<Integer> qx = new LinkedList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    qy.add(i);
                    qx.add(j);
                }
            }
        }
        if (qy.size() == 0 || qy.size() == n*n)
            return -1;
        while (qy.size() > 0) {
            int size = qy.size();
            boolean hasNew = false;
            for (int s = 0; s < size; s++) {
                int r = qy.poll();
                int c = qx.poll();
                if (seen[r][c]) continue;
                seen[r][c] = true;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dirs[d];
                    int nc = c + dirs[d+1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1)
                        continue;
                    qy.add(nr);
                    qx.add(nc);
                    hasNew = true;
                }
            }
            if (!hasNew) break;
            step++;
        }
        return step-1;
    }
    
}
