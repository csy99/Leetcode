/**
 * Created by csy99 on 12/1/22.
 */
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            int row_1 = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    row_1++;
            }
            int diff = row_1 * 2 - n;
            for (int j = 0; j < n; j++)
                res[i][j] = diff;
        }
        
        for (int j = 0; j < n; j++) {
            int col_1 = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1)
                    col_1++;
            }
            int diff = col_1 * 2 - m;
            for (int i = 0; i < m; i++) 
                res[i][j] += diff;
        }
        
        return res;
    }
}
