package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
  Each 0 marks an empty land which you can pass by freely.
  Each 1 marks a building which you cannot pass through.
  Each 2 marks an obstacle which you cannot pass through.
 Example 1

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation:
In this example, there are three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 */
public class Q317_Shortest_Distance_from_All_Buildings {
    int m;
    int n;
    int[][] canReach;
    int[][] dist;
    int[] dirs = {-1, 0, 1, 0, -1};
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        if (n == 0) return 0;
        canReach = new int[m][n];
        dist = new int[m][n];
        
        int buildings = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    if (!bfs(grid, i, j))
                        return -1;
                }
            }
        
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (canReach[i][j] == buildings && dist[i][j] < minDist)
                    minDist = dist[i][j];
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    
    private boolean valid(int[][] grid, int y, int x, boolean[][] visited) {
        if (y < 0 || x < 0 || y >= m || x >= n)
            return false;
        if (grid[y][x] == 2)
            return false;
        if (visited[y][x])
            return false;
        return true;
    }
    
    private boolean bfs(int[][] grid, int r, int c) {
        Queue<Integer> hori = new LinkedList();
        Queue<Integer> vert = new LinkedList();
        boolean[][] visited = new boolean[m][n];
        hori.offer(r);
        vert.offer(c);
        visited[r][c] = true;
        int step = 0;
        while (hori.size() > 0) {
            int size = hori.size();
            step++;
            for (int s = 0; s < size; s++) {
                Integer y = hori.poll();
                Integer x = vert.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = y+dirs[d];
                    int nx = x+dirs[d+1];
                    if (!valid(grid, ny, nx, visited))
                        continue;
                    if (grid[ny][nx] == 0) {
                        hori.offer(ny);
                        vert.offer(nx);
                        dist[ny][nx] += step;
                        canReach[ny][nx]++;
                    }
                    visited[ny][nx] = true;
                }
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && !visited[i][j])
                    return false;
    
        return true;
    }
}
