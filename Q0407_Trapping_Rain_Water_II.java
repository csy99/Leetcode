package Leetcode;

/**
 * Created by csy99 on 8/26/20.
 */
public class Q407_Trapping_Rain_Water_II {
class Solution {
    int[] dirs = new int[] {-1, 0, 1, 0, -1}; 
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue();
        for (int i = 0; i < m; i++) {
            Cell c1 = new Cell(i, 0, heightMap[i][0]);
            Cell c2 = new Cell(i, n-1, heightMap[i][n-1]);
            visited[i][0] = visited[i][n-1] = true;
            pq.offer(c1);
            pq.offer(c2);
        }
        for (int j = 1; j < n-1; j++) {
            Cell c1 = new Cell(0, j, heightMap[0][j]);
            Cell c2 = new Cell(m-1, j, heightMap[m-1][j]);
            visited[m-1][j] = visited[m-1][j] = true;
            pq.offer(c1);
            pq.offer(c2);            
        }
        int res = 0;
        while (pq.size() > 0) {
            Cell cur = pq.poll();
            int r = cur.row;
            int c = cur.col;
            int h = cur.height;
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d];
                int nc = c + dirs[d+1];
                // corners cannot contain water, no need to check again 
                if (nr <= 0 || nc <= 0 || nr >= m - 1 || nc >= n - 1 || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                res += Math.max(0, h - heightMap[nr][nc]);
                pq.offer(new Cell(nr, nc, Math.max(h, heightMap[nr][nc])));
            }
        }
        return res;
    }
}

class Cell implements Comparable<Cell> {
    int row;
    int col;
    int height;
    
    public Cell(int r, int c, int h) {
        row = r;
        col = c;
        height = h;
    }
    
    public int compareTo(Cell c2) {
        return Integer.compare(this.height, c2.height);
    }
}
