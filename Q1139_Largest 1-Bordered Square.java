/**
 * Created by csy99 5/4/20. 
 */
class Solution {
    // time: O(min(m,n)*m*n), space: O(mn)
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int[][] sum = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = grid[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        for (int len = Math.min(n, m); len > 0; len--) {
            for (int x1 = 1, x2 = x1+len-1; x2 <= m; x1++, x2++) {
                for (int y1 = 1, y2 = y1+len-1; y2 <= n; y1++, y2++) {
                    // check every side of a square in O(1)
                    if (getArea(x1, y1, x2, y1, sum) == len &&
                       getArea(x1, y1, x1, y2, sum) == len &&
                       getArea(x1, y2, x2, y2, sum) == len &&
                       getArea(x2, y1, x2, y2, sum) == len)
                        return len * len;
                }
            }
        }
        return 0;
    }
    
    private int getArea(int x1, int y1, int x2, int y2, int[][] sum) {
        return sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
    }
}
