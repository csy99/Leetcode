package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        int[][] path = new int[m+1][n+1];
        path[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) 
                path[i][j] =  obstacleGrid[i-1][j-1] == 1? 0 : path[i-1][j] + path[i][j-1];
        }
        return path[m][n];
    }
}
