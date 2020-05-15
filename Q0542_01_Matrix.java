package Leetcode;

/**
 * Created by csy99 on 5/14/20. 
 */
public class Q542_01_Matrix {
    int[][] res;
    boolean[][] seen;
    int m;
    int n;
    int[] dirs = new int[] {0, -1, 0, 1, 0};
    public int[][] updateMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        res = new int[m][n];
        seen = new boolean[m][n];
        Queue<Coord> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) 
                    res[i][j] = (int)1e9;
                else {
                    q.offer(new Coord(i, j));
                    seen[i][j] = true;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Coord cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                res[y][x] = step;
                for (int di = 0; di < 4; di++) {
                    int ny = y + dirs[di];
                    int nx = x + dirs[di+1];
                    if (!valid(ny, nx) || seen[ny][nx]) continue;
                    seen[ny][nx] = true;
                    q.offer(new Coord(ny, nx));
                }
            }
            step++;
        }
        return res;
    }
    
    private boolean valid(int y, int x) {
        if (y < 0 || y >= m || x < 0 || x >= n)
            return false;
        return true;
    }
}

class Coord {
    int y;
    int x;
    public Coord(int a, int b) {
        y = a;
        x = b;
    }
}
