package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 * <p>
 * https://leetcode.com/problems/unique-paths/
 */
public class Q062_Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m+1][n+1];
        path[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) 
                path[i][j] = path[i-1][j] + path[i][j-1];
        }
        return path[m][n];
    }
}
