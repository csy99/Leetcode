package Leetcode;

/**
 * Created by csy99 on 9/25/20.
 */
public class Q463_Island_Perimeter {
    int[][] grid;
    int m;
    int n;
    int[] dirs = new int[] {-1, 0, 1, 0, -1};
    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int y = i + dirs[d];
                    int x = j + dirs[d+1];
                    if (hasBorder(y,x))
                        perimeter++;
                }
            }
        }
        return perimeter;
    }
    
    private boolean hasBorder(int y, int x) {
        if (y < 0 || y >= m || x < 0 || x >= n)
            return true;
        if (grid[y][x] == 0)
            return true;
        return false;
    }
}
