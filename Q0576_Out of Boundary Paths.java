/**
 * Created by csy99 on 5/4/20. 
 */
class Solution {
    // Convert the problem to walking from outside to (i, j) in at most N steps
    // Given one more step, there are only four ways to achieve this. (how states transform)
    public int findPaths(int m, int n, int N, int i, int j) {
        int kMod = 1_000_000_007;
        int[][] ways = new int[m][n];
        int[] dirs = new int[] {-1, 0, 1, 0, -1};
        for (int s = 0; s < N; s++) {
            int[][] cur = new int[m][n];
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    for (int d = 0; d < 4; d++) {
                        int ty = y + dirs[d];
                        int tx = x + dirs[d+1];
                        if (ty < 0 || tx < 0 || ty >= m || tx >= n)
                            cur[y][x] += 1;
                        else
                            cur[y][x] = (cur[y][x] + ways[ty][tx]) % kMod;
                    }
                }
            }
            ways = cur;
        }
        return ways[i][j];
    }
}
