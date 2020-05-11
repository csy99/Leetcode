/**
 * Created by csy99 on 5/4/20.
 */
class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] ways = new double[N][N];
        ways[r][c] = 1;
        int[][] dirs = new int[][] {
            {1, 2}, {-1, -2}, {1, -2}, {-1, 2},
            {2, 1}, {-2, -1}, {-2, 1}, {2, -1}
        };
        for (int k = 0; k < K; k++) {
            double[][] cur = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int m = 0; m < 8; m++) {
                        int y = i + dirs[m][0];
                        int x = j + dirs[m][1];
                        if (x < 0 || y < 0 || x >= N || y >= N)
                            continue;
                        cur[i][j] += ways[y][x]; 
                    }
                }
            }
            ways = cur;
        }
        double total = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                total += ways[i][j];
        return total / Math.pow(8, K);
    }
}
