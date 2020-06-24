package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 *
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
 * since the wall is too strong to be destroyed. You can only put the bomb at an empty cell.
 */
public class Q361_Bomb_Enemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int[][] top = new int[m][n];
        int[][] bot = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') 
                    continue;
                if (grid[i][j] == 'E') {
                    top[i][j] = 1;
                    left[i][j] = 1;
                }
                if (i > 0)
                    top[i][j] += top[i-1][j];
                if (j > 0)
                    left[i][j] += left[i][j-1];
            }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (grid[i][j] == 'W')
                    continue;
                if (grid[i][j] == 'E') {
                    bot[i][j] = 1;
                    right[i][j] = 1;
                }
                if (i < m-1) 
                    bot[i][j] += bot[i+1][j];
                if (j < n-1)
                    right[i][j] += right[i][j+1];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == '0')
                    res = Math.max(res, top[i][j]+bot[i][j]+left[i][j]+right[i][j]);
        return res;
    }
}
