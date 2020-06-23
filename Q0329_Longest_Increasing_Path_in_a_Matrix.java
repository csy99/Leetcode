package Leetcode;

/**
 * Created by csy99 on 3/31/20.
 */
public class Q329_Longest_Increasing_Path_in_a_Matrix {
    int m;
    int n;
    int[][] leng;
    int[] dirs = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        if (n == 0) return 0;
        leng = new int[m][n];
        int longest = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                longest = Math.max(longest, dfs(matrix, i, j, matrix[i][j]-1));
        return longest;
    }
    
    private int dfs(int[][] matrix, int y, int x, int prev) {
        if (y < 0 || x < 0 || y >= m || x >= n || matrix[y][x] <= prev)
            return 0;
        if (leng[y][x] > 0)
            return leng[y][x];
        for (int d = 0; d < 4; d++) 
            leng[y][x] = Math.max(leng[y][x], 1+dfs(matrix, y+dirs[d], x+dirs[d+1], matrix[y][x]));
        return leng[y][x];
    }
}
